package com.bishe.main.controller;

import com.bishe.main.constant.ConstantParameter;
import com.bishe.main.dto.ProblemAnswerDTO;
import com.bishe.main.entity.Problem;
import com.bishe.main.entity.SubmitRecord;
import com.bishe.main.entity.User;
import com.bishe.main.entity.result.CodeMsg;
import com.bishe.main.entity.result.Result;
import com.bishe.main.service.ProblemService;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Kirito
 * @Date 2020/4/14 17:17
 */
@RestController
@RequestMapping("/problem/api")
public class ProblemContoller {
    @Autowired
    private ProblemService problemService;

    @ApiOperation("分页获取OJ问题")
    @GetMapping("/pros/{page}")
    public Result<Page<Problem>> getProblemByPage(@PathVariable("page") Integer page){
        Result<Page<Problem>> result = Result.success(problemService.getProblem(page));
        result.setPage(problemService.getPageCount());
        return result;
    }

    @ApiOperation("获取OJ题详情")
    @GetMapping("/pro/{id}")
    public Result<Problem> getProblemById(@PathVariable("id") Long id){
        return Result.success(problemService.getProblemById(id));
    }

    @ApiOperation("开启沙盒")
    @GetMapping("/open_send_box")
    public Result openSendBox(){
        problemService.openNewSendBox();
        return Result.success("开启成功");
    }

    @ApiOperation("提交OJ")
    @PostMapping("/submit_oj")
    public Result submitOJ(@RequestBody ProblemAnswerDTO problem, HttpServletRequest request){
        // 间隔时间， 6秒后才能再次提交代码
        Long invideTime = (Long) request.getSession().getAttribute(ConstantParameter.SUBMIT_RECORD_TOKEN_NAME);
        // 间隔时间不为空且大于当前时间
        if(invideTime != null && invideTime.longValue() > System.currentTimeMillis()){
            CodeMsg codeMsg = new CodeMsg(501, "两次提交间隔不能少于6秒");
            return Result.error(codeMsg);
        }

//        User user = (User) request.getSession().getAttribute("user");
        User user = new User();
        user.setUserId("6aca7cbe-dff0-4342-a4f4-c7ad86699c4b");
        problem.setUser(user);
        problemService.submitAnswer(problem);
        // 6秒后才能再次提交
        request.getSession().setAttribute(ConstantParameter.SUBMIT_RECORD_TOKEN_NAME, System.currentTimeMillis() + ConstantParameter.SUBMIT_RECORD_GAP);

        SubmitRecord submitRecord = null;
        try{
            Thread.sleep(3000);
            submitRecord = problemService.getSubmitRecordById();
        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.success(submitRecord);
    }
}
