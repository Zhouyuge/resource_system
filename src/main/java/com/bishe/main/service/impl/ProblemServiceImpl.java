package com.bishe.main.service.impl;

import com.bishe.main.constant.ConstantParameter;
import com.bishe.main.dao.OjRecordMapper;
import com.bishe.main.dao.ProblemMapper;
import com.bishe.main.dao.SubmitRecordMapper;
import com.bishe.main.dto.JudgeProblemDTO;
import com.bishe.main.dto.ProblemAnswerDTO;
import com.bishe.main.dto.ProblemJudgeDTO;
import com.bishe.main.dto.ProblemJudgeResultDTO;
import com.bishe.main.entity.*;
import com.bishe.main.exceptions.CodeRunException;
import com.bishe.main.service.ProblemService;
import com.bishe.main.service.SendBoxService;
import com.bishe.main.util.EncryptUtility;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Kirito
 * @Date 2020/4/14 17:13
 */
@Service
@Scope("singleton")
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private SubmitRecordMapper submitRecordMapper;

    @Autowired
    private OjRecordMapper ojRecordMapper;

    private SendBoxService sendBoxService = SendBoxService.getInstance();

    private static final Integer pageSize = 20;

    private Long submitId;

    private Long pageCount;

    // 正确题的id
    private List<Long> rightIds = new ArrayList<>();

    // 做过题的id
    private List<Long> doIds = new ArrayList<>();

    private Pattern packagePattern = Pattern.compile("^[ ]*package.*;");
    private Pattern classNamePattern = Pattern
            .compile("public[ ]*class[ ]*Main[ ]*\\{");
    private Pattern mainMethodPattern = Pattern
            .compile("public[ ]*static[ ]*void[ ]*main");

    @Override
    public Page<Problem> getProblem(Integer pageNum) {
        Page<Problem> problemPage = PageHelper.startPage(pageNum, pageSize);
        List<Problem> problems = problemMapper.getProblem();
        pageCount = problemPage.getTotal();
        return problemPage;
    }

    @Override
    public void openNewSendBox(){
        sendBoxService.openNewJavaSandbox();
    }

    @Override
    public Problem getProblemById(Long id) {
        return problemMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer getPageCount() {
        return Integer.valueOf(pageCount.toString());
    }

    public Long initSubmitId(){
        submitId = submitRecordMapper.getSubmitCount();
        submitId += 1;
        return submitId;
    }

    @Override
    @Transactional
    public SubmitRecord getSubmitRecordById() {
        return submitRecordMapper.selectByPrimaryKey(submitId);
    }

    @Override
    public void submitAnswer(ProblemAnswerDTO dto) {
        // 校验答案
        checkCode(dto.getCode());

        User user = dto.getUser();

        // 拼接java文件名,并修改主类名,规则为: userId_problemIdMain
        String prefix = "s" + dto.getUser().getUserId().replaceAll("-", "s");
        String javaFileName = prefix + "_" + System.currentTimeMillis() + "Main";
        // 替换主类名为文件名
        String code = dto.getCode().replace("Main", javaFileName);

        // 创建当天的代码提交文件夹
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
        File file = new File(ConstantParameter.CLASS_FILE_ROOT_PATH + File.separator + today);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fos = null;
        String javaFilePath = file.getAbsolutePath() + File.separator + javaFileName + ConstantParameter.DEFAULT_CODE_FILE_SUFFIX;
        try {
            fos = new FileOutputStream(javaFilePath);
            fos.write(code.getBytes(), 0, code.getBytes().length);

            SubmitRecord submitRecord = new SubmitRecord();
            // 是否通过，默认没通过
            submitRecord.setSubmitId(initSubmitId());
            submitRecord.setIsAccepted(false);
            submitRecord.setCodeFilePath(javaFilePath);
            submitRecord.setCodeLanguage(dto.getCodeLanguage());
            // 默认成绩 0
            submitRecord.setScore(0d);
            submitRecord.setDetails("开始编译");
            submitRecord.setSubmitProblemId(dto.getSubmitProblemId().longValue());
            submitRecord.setSubmitTime(new Date());
            submitRecord.setSubmitUserId(user.getUserId());
            submitRecord.setSubmitRecordTableName("submit_record");
            OjRecordWithBLOBs record = initOjRecord(submitRecord.getSubmitProblemId(), user.getUserId());
            submitRecordMapper.insertSelective(submitRecord);
            // 发送判题请求
            sendOJToJudge(dto, javaFilePath, submitRecord, record);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CodeRunException("创建文件失败，无法保存代码");
        }finally {
            try {
                fos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 初始化提交记录
     * @param problemId
     */
    private OjRecordWithBLOBs initOjRecord(Long problemId, String userId) {
        OjRecordWithBLOBs record = ojRecordMapper.selectByUserId(userId);
        // 如果数据库中还没有做题记录
        if (record == null) {
            record = new OjRecordWithBLOBs();
            record.setUserId(userId);
            record.setDoProblemId(problemId + " ");
            ojRecordMapper.insertSelective(record);
        } else {
            if(record.getDoProblemId() == null) {
                record.setDoProblemId(problemId + " ");
            } else {
                doIds = Arrays.asList(record.getDoProblemId().split(" ")).stream().map(
                        e -> {
                            return Long.valueOf(e);
                        }
                ).collect(Collectors.toList());
                if( ! doIds.contains(problemId)){
                   record.setDoProblemId(record.getDoProblemId() + " " + problemId);
                }
            }
            ojRecordMapper.updateByPrimaryKeyWithBLOBs(record);
        }
        return record;
    }
    private void checkCode(String code) {
        Matcher matcher = packagePattern.matcher(code);
        if (matcher.find()) {
            throw new CodeRunException("不能有package代码");
        }
        matcher = classNamePattern.matcher(code);
        if (!matcher.find()) {
            throw new CodeRunException("主类名必须是Main");
        }
        matcher = mainMethodPattern.matcher(code);
        if (!matcher.find()) {
            throw new CodeRunException("没有静态的main方法入口");
        }
    }

    public void sendOJToJudge(ProblemAnswerDTO dto, String javaFilePath,
                              SubmitRecord submitRecord, OjRecordWithBLOBs record) {
        // 查询出题目信息及相关要求
        Problem problem = problemMapper.selectByPrimaryKey(dto.getSubmitProblemId().longValue());
        JudgeProblemDTO judgeProblemDTO = new JudgeProblemDTO();
        judgeProblemDTO.setJavaFilePath(javaFilePath);
        judgeProblemDTO.setRunId(UUID.randomUUID().toString());
        judgeProblemDTO.setMemoryLimit(problem.getMemoryLimit());
        judgeProblemDTO.setTimeLimit(problem.getTimeLimit());

        List<String> fileOutPaths = getFileList(problem.getOutputFileRootPath());
        List<String> fileInPaths = getFileList(problem.getInputFileRootPath());
        judgeProblemDTO.setProblemInputPathList(fileInPaths);
        judgeProblemDTO.setProblemOutputPathList(fileOutPaths);
        judgeProblemDTO.setJudgeResultListener(new JudgeResultListener("submit_record", submitRecord.getSubmitId(),
                dto.getUser().getUserId(), problem, record));

        sendBoxService.judgeProblem(judgeProblemDTO, new SendBoxService.ErrorListener(){
            @Override
            public void onError(Exception exception) {
                submitRecord.setDetails(exception.getMessage());
                submitRecordMapper.updateByPrimaryKeySelective(submitRecord);
            }
        });
    }


    private List<String> getFileList(String rootPath) {
        File inputFileDir = new File(rootPath);
        String[] fileNames = inputFileDir.list();
        List<String> inputPaths = new ArrayList<String>(fileNames.length);

        for (int i = 0; i < fileNames.length; i++) {
            inputPaths.add(rootPath + File.separator + fileNames[i]);
        }
        return inputPaths;
    }

    private class JudgeResultListener implements SendBoxService.JudgeResultListener {
        private String submitRecordTableName;
        private Long submitRecordId;
        private String userId;
        private Problem problem;
        private OjRecordWithBLOBs record;

        public JudgeResultListener(String submitRecordTableName,
                                   Long submitRecordId, String userId, Problem problem, OjRecordWithBLOBs record) {
            super();
            this.submitRecordTableName = submitRecordTableName;
            this.submitRecordId = submitRecordId;
            this.userId = userId;
            this.problem = problem;
            this.record = record;
        }

        @Override
        public void judgeResult(ProblemJudgeDTO problemJudgeResult) {
            SubmitRecord submitRecord = new SubmitRecord();
            submitRecord.setSubmitRecordTableName(submitRecordTableName);
            submitRecord.setSubmitId(submitRecordId);
            submitRecord.setSubmitUserId(userId);

            if(problemJudgeResult.getCorrectRate() >= 1.0){
                submitRecord.setIsAccepted(true);
                problem.setTotalRightCount(problem.getTotalRightCount() + 1);
                // 更新到Oj刷题记录表
                if(record.getRightProblemId() == null){
                    record.setRightProblemId(problem.getProblemId() + " ");
                } else {
                    rightIds = Arrays.asList(record.getRightProblemId().split(" ")).stream().map(
                            e -> {
                                return Long.valueOf(e);
                            }
                    ).collect(Collectors.toList());
                    if( ! rightIds.contains(problem.getProblemId())){
                        record.setRightProblemId(record.getRightProblemId() + " " + problem.getProblemId());
                    }
                }
                ojRecordMapper.updateByPrimaryKeyWithBLOBs(record);
            } else {
                submitRecord.setIsAccepted(false);
            }
            // 更新提交总数
            problem.setTotalSubmitCount(problem.getTotalSubmitCount() + 1);
            problemMapper.updateByPrimaryKey(problem);

            submitRecord.setScore(new Double(problemJudgeResult.getCorrectRate() * 100));
            List<ProblemJudgeResultDTO> problemJudgeResultItems = problemJudgeResult
                    .getProblemJudgeResultItems();
            ProblemJudgeResultDTO tempResultItem = null;
            // 先加密里面的输入输出文件路径
            for (int i = 0; i < problemJudgeResultItems.size(); i++) {
                tempResultItem = problemJudgeResultItems.get(i);
                try {
                    tempResultItem
                            .setInputFilePath(Base64Utils
                                    .encodeToUrlSafeString(EncryptUtility
                                            .AESEncoding(
                                                    ConstantParameter.PROBLEM_STANDARD_FILE_PATH_SEED,
                                                    tempResultItem
                                                            .getInputFilePath())
                                            .getBytes()));

                    tempResultItem
                            .setOutputFilePath(Base64Utils
                                    .encodeToUrlSafeString(EncryptUtility
                                            .AESEncoding(
                                                    ConstantParameter.PROBLEM_STANDARD_FILE_PATH_SEED,
                                                    tempResultItem
                                                            .getOutputFilePath())
                                            .getBytes()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String details = new Gson().toJson(problemJudgeResultItems);
            submitRecord.setDetails(details);

            submitRecordMapper.updateByPrimaryKeySelective(submitRecord);

        }
    }
}