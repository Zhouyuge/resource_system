package com.bishe.main.service;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.superman.sandbox.dto.*;
import com.bishe.main.constant.CommunicationSignal;
import com.bishe.main.constant.ConstantParameter;
import com.bishe.main.dto.*;
import com.bishe.main.exceptions.CodeRunException;
import com.bishe.main.executor.ResponseExecutor;
import com.bishe.main.manager.CommunicatorManager;
import com.bishe.main.manager.SandboxStatusObserver;
import com.bishe.main.util.ThreadFactoryUtil;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author Kirito
 * @Date 2020/4/16 20:58
 */
public class SendBoxService {

    private Map<String, SandboxStatus> sandboxStatusMap = new ConcurrentHashMap<String, SandboxStatus>();

    private Log log = LogFactory.get(SendBoxService.class);

    private static volatile SendBoxService sendBoxService;

    private List<SandboxStatusObserver> sandboxStatusObservers = new CopyOnWriteArrayList<SandboxStatusObserver>();
    private ScheduledExecutorService statusTimer = Executors
            .newScheduledThreadPool(1, ThreadFactoryUtil
                    .getLogThreadFactory(SendBoxService.class.getName()
                            + " statusTimer"));

    public interface JudgeResultListener {
        void judgeResult(ProblemJudgeDTO problemJudgeResult);
    }

    public static interface ErrorListener {
        void onError(Exception exception);
    }

    private CommunicatorManager communicatorManager = null;

    private ExecutorService executorService = Executors.newCachedThreadPool(
            ThreadFactoryUtil.getLogThreadFactory(SendBoxService.class.getName() + "executorService"));

    // 单例模式
    public static SendBoxService getInstance(){
        if (sendBoxService == null){
            synchronized (SendBoxService.class){
                if(sendBoxService == null){
                    sendBoxService = new SendBoxService();
                }
            }
        }
        return sendBoxService;
    }


    private SendBoxService() {
        communicatorManager = CommunicatorManager.getInstance();
        openStatusListen();
    }

    private void openStatusListen() {
        // 每500毫秒，更新一次状态
        statusTimer.scheduleAtFixedRate(new Runnable() {
            private int count = 0;

            @Override
            public void run() {
                if (sandboxStatusMap.size() > 0) {
                    Iterator<Map.Entry<String, SandboxStatus>> iterator = sandboxStatusMap
                            .entrySet().iterator();
                    Map.Entry<String, SandboxStatus> entry;
                    while (iterator.hasNext()) {
                        entry = iterator.next();
                        // 相当于每5秒，通过网络向沙箱获取一次状态
                        if (count == 10) {
                            try {
                                fillingSandboxStatusData(entry.getValue(), true);
                            } catch (Exception e) {
                                // 先简单处理，只要获取错误，就当做是这个沙箱线程意外的死亡了，直接做死亡处理
                                e.printStackTrace();
                                iterator.remove();
                                log.error("沙箱死亡了");
                                communicatorManager
                                        .closeSandboxConnectById(entry
                                                .getValue().getIdCard());
                            }
                        } else {
                            fillingSandboxStatusData(entry.getValue(), false);
                        }
                    }
                    count++;
                    count %= 11;
                }

                notifyAllStatusObserver(sandboxStatusMap.values());
            }
        }, 0, 500, TimeUnit.MILLISECONDS);
    }

    private void notifyAllStatusObserver(Collection<SandboxStatus> status) {
        for (SandboxStatusObserver observer : sandboxStatusObservers) {
            observer.statusChanged(status);
        }
    }

    private static int portIndex = 10;
    private static int basePortIndex = 60000;

    private synchronized int getValidport() {
        if (portIndex >= 5535) {
            basePortIndex -= 10000;
            portIndex = 10;
        }
        portIndex++;
        return basePortIndex + portIndex;
    }

    public void openNewJavaSandbox() {
        executorService.execute(new Runnable() {

            @Override
            public void run() {
                String ip = "127.0.0.1";
                int port = getValidport();
                JavaSandboxStartInfo sandboxStartInfo = new JavaSandboxStartInfo();
                sandboxStartInfo.setIp(ip);
                sandboxStartInfo.setPort(port);
                // 字符串前面和后面不多添加一个"的话，沙箱那边收到的json数据有问题
                sandboxStartInfo.setProblemClassFileRootPath("\""
                        + ConstantParameter.CLASS_FILE_ROOT_PATH + "\"");
                try {
                    sandboxStartInfo.setJarFilePath(ResourceUtils.getFile(
                            ResourceUtils.CLASSPATH_URL_PREFIX
                                    + "sandbox/JavaOJSandbox.jar")
                            .getAbsolutePath());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return;
                }

                String sandboxIdCard = communicatorManager
                        .makeNewSandBox(sandboxStartInfo);
                if (sandboxIdCard == null) {
                    throw new CodeRunException("创建失败");
                }

                SandboxStatus sandboxStatus = new SandboxStatus(sandboxIdCard,
                        ip, port);
                sandboxStatusMap.put(sandboxIdCard, sandboxStatus);
                fillingSandboxStatusData(sandboxStatus, true);
            }
        });

    }

    /**
     * @param getFullData
     *            如果为true的话，这个方法还会向沙箱发出一个请求,远程获得该沙箱的一些信息（比如，当前使用内存，pid等）
     */
    private void fillingSandboxStatusData(SandboxStatus sandboxStatus,
                                          boolean getFullData) {
        if (getFullData) {
            CommonRequest commonRequest = new CommonRequest();
            commonRequest.setExecutor(new SandboxStatusResponseExecutor(
                    sandboxStatus));
            Request request = new Request();
            request.setCommand(CommunicationSignal.RequestSignal.SANDBOX_STATUS);
            commonRequest.setRequest(request);
            communicatorManager.publicCommonRequest(sandboxStatus.getIdCard(),
                    commonRequest);
        }

        CommunicatorStatus communicatorStatus = communicatorManager
                .getCommunicatorStatus(sandboxStatus.getIdCard());
        sandboxStatus.setJudgeing(communicatorStatus.isJudgeing());
        sandboxStatus.setWantClose(communicatorStatus.isWantClose());
        sandboxStatus.setWantStop(communicatorStatus.isWantStop());
        sandboxStatus.setRunning(communicatorStatus.isStop() == true ? false
                : true);
    }

    public void judgeProblem(final JudgeProblemDTO judgeProblemDTO, final ErrorListener errorListener){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    // 编译java文件
                    boolean flag = compilerJavaFile(judgeProblemDTO.getJavaFilePath(),
                            ConstantParameter.CLASS_FILE_ROOT_PATH);
                    if(! flag){
                        if(errorListener != null){
                            errorListener.onError(new CodeRunException("编译失败"));
                        }
                        return;
                    }
                    JudgeProblemRequest judgeProblemRequest = new JudgeProblemRequest();
                    judgeProblemRequest.setExecutor(new ProblemResponseExecutor(
                            judgeProblemDTO.getProblemOutputPathList(),
                            judgeProblemDTO.getJudgeResultListener()
                    ));

                    Request request = new Request();
                    request.setCommand(CommunicationSignal.RequestSignal.REQUSET_JUDGED_PROBLEM);
                    Problem problem = new Problem();
                    problem.setTimeLimit(Integer.valueOf(judgeProblemDTO.getTimeLimit() + ""));
                    problem.setRunId(judgeProblemDTO.getRunId());
                    // 数据库记录的是KB，但是沙箱那边要的是B，所以这里要转换一下单位
                    problem.setMemoryLimit(judgeProblemDTO.getMemoryLimit() * 1024);
                    problem.setInputDataFilePathList(judgeProblemDTO
                            .getProblemInputPathList());
                    // 截取文件名 例如: D://java//Main.java --> Main
                    problem.setClassFileName(judgeProblemDTO.getJavaFilePath().substring(judgeProblemDTO.getJavaFilePath().lastIndexOf(File.separator) + 1,
                            judgeProblemDTO.getJavaFilePath().lastIndexOf(".")));
                    request.setData(new Gson().toJson(problem));
                    judgeProblemRequest.setRequest(request);
                    communicatorManager
                            .publicJudgeProblemRequest(judgeProblemRequest);
                } catch (Exception e){
                    if (errorListener != null) {
                        errorListener.onError(e);
                    }
                }
            }
        });
    }

    private void processJudgeResult(Response response,
                                    List<String> problemOutputPathList,
                                    JudgeResultListener judgeResultListener) {
        ProblemJudgeDTO problemJudgeResult = new ProblemJudgeDTO();
        List<ProblemJudgeResultDTO> problemJudgeResultItems = new ArrayList<ProblemJudgeResultDTO>();
        ProblemResult problemResult = new Gson().fromJson(response.getData(),
                ProblemResult.class);
        List<ProblemResultItem> resultItems = problemResult.getResultItems();

        if (resultItems == null || resultItems.size() == 0) {
            if (judgeResultListener != null) {
                problemJudgeResult.setCorrectRate(0);
                problemJudgeResult.setProblemJudgeResultItems(Collections
                        .<ProblemJudgeResultDTO> emptyList());
                judgeResultListener.judgeResult(problemJudgeResult);
                return;
            }
        }

        // 准备好输出文件信息，用于与输入文件匹配,用文件名匹配，因为匹配的输入输出文件名是一致的
        Map<String, String> outputFilesMap = new HashMap<String, String>();
        String tempString = null;
        for (int i = 0; i < problemOutputPathList.size(); i++) {
            tempString = problemOutputPathList.get(i);
            outputFilesMap.put(tempString.substring(
                    tempString.lastIndexOf(File.separator) + 1,
                    tempString.length()), tempString);
        }

        int correctProblemCount = 0;
        ProblemJudgeResultDTO judgeResultItem = null;
        String itemOutputFilePath = null;

        for (ProblemResultItem resultItem : resultItems) {
            if (resultItem == null || resultItem.getInputFilePath() == null) {
                continue;
            }

            judgeResultItem = new ProblemJudgeResultDTO();
            // 根据输入文件和输出文件约定的规则，获取相应的输出文件
            tempString = resultItem.getInputFilePath();
            itemOutputFilePath = outputFilesMap.get(tempString.substring(
                    tempString.lastIndexOf(File.separator) + 1,
                    tempString.length()));

            if (resultItem.isNormal()) {
                boolean isRight = checkResultIsRightORNot(itemOutputFilePath,
                        resultItem.getResult());
                if (isRight) {
                    judgeResultItem.setMessage("答案正确");
                    judgeResultItem.setRight(true);
                    correctProblemCount++;
                } else {
                    judgeResultItem.setMessage("答案错误");
                }

            } else {
                // 这些是还没判断结果，就已经有问题的
                judgeResultItem.setMessage(resultItem.getMessage());
            }

            judgeResultItem.setUseTime(resultItem.getUseTime());
            // 因为那边返回的是B，这里要转换为KB
            judgeResultItem.setUseMemory(resultItem.getUseMemory() / 1024);
            judgeResultItem.setInputFilePath(resultItem.getInputFilePath());
            judgeResultItem.setOutputFilePath(itemOutputFilePath);
            problemJudgeResultItems.add(judgeResultItem);
        }

        problemJudgeResult.setRunId(problemResult.getRunId());
        problemJudgeResult.setCorrectRate((float) correctProblemCount
                / resultItems.size());
        problemJudgeResult.setProblemJudgeResultItems(problemJudgeResultItems);

        if (judgeResultListener != null) {
            judgeResultListener.judgeResult(problemJudgeResult);
        }
    }


    private boolean checkResultIsRightORNot(String standardResultFilePath,
                                            String beTestedResult) {
        FileInputStream inputStream = null;
        Scanner scanner = null;
        StringBuilder builder = new StringBuilder();

        try {
            inputStream = new FileInputStream(standardResultFilePath);
            scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine() + "\r\n");
            }

            return builder.toString().equals(beTestedResult);
        } catch (Exception e) {
            throw new RuntimeException("匹配失败" + e.getMessage());
        } finally {
            try {
                inputStream.close();
                scanner.close();
            } catch (IOException e) {
            }
        }
    }


    public static boolean compilerJavaFile(String sourceFileInputPath, String classFileOutputPath) {
        // 设置编译选项，配置class文件输出路径
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        Iterable<String> options = Arrays.asList("-d", classFileOutputPath);
        StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);

        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(new File(sourceFileInputPath)));

        return javaCompiler.getTask(null, fileManager, null, options, null, compilationUnits).call();
    }

    private class ProblemResponseExecutor implements ResponseExecutor {
        private List<String> problemOutputPathList;
        private JudgeResultListener judgeResultListener;

        public ProblemResponseExecutor(List<String> problemOutputPathList,
                                       JudgeResultListener judgeResultListener) {
            this.problemOutputPathList = problemOutputPathList;
            this.judgeResultListener = judgeResultListener;
        }

        @Override
        public void executor(Response response) {
            processJudgeResult(response, problemOutputPathList,
                    judgeResultListener);
        }
    }

    private static class SandboxStatusResponseExecutor implements
            ResponseExecutor {
        private SandboxStatus sandboxStatus;

        public SandboxStatusResponseExecutor(SandboxStatus sandboxStatus) {
            this.sandboxStatus = sandboxStatus;
        }

        @Override
        public void executor(Response response) {
            SandBoxStatus status = new Gson().fromJson(response.getData(),
                    SandBoxStatus.class);
            sandboxStatus.setBeginTime(status.getBeginStartTime());
            sandboxStatus.setPid(status.getPid());
            sandboxStatus.setUseMemory(status.getUseMemory());
            sandboxStatus = null;
        }

    }
}
