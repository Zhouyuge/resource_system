package com.bishe.main.controller;

import com.bishe.main.entity.Resume;
import com.bishe.main.entity.User;
import com.bishe.main.entity.result.Result;
import com.bishe.main.service.WorkService;
import com.bishe.main.util.MapUtil;
import com.bishe.main.vo.SelfDetailVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Kirito
 * @Date 2020/1/7 19:12
 */
@RestController
@RequestMapping("/work/api")
public class WorkController {
    @Autowired
    private WorkService workService;

    @PostMapping("/resume")
    @ApiOperation("生成简历")
    public Map<String, Object> generatorResume(HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        User user = (User)request.getSession().getAttribute("user");
        String userId = user.getUserId();
        String resumeStr = request.getParameter("resume");
        SelfDetailVO selfDetailVO = new ObjectMapper().readValue(resumeStr, SelfDetailVO.class);
        Integer code = workService.generatorPdf(selfDetailVO, userId);
        if (code == 200) {
            resultMap = MapUtil.sucMsg("简历生成成功！");
        } else {
            resultMap = MapUtil.errMsg("简历生成出错！");
        }
        return resultMap;
    }

    @ApiOperation("获取个人简历")
    @GetMapping("/resume/{user_id}")
    public Result<List> getResumeList(@PathVariable("user_id") String userId){
        return Result.success(workService.getUserResumeList(userId));
    }

    @ApiOperation("通过id获取简历")
    @GetMapping("/resume_id/{id}")
    public Result<Resume> getResumeById(@PathVariable("id") Integer id){
        return Result.success(workService.getResumeById(id));
    }

    @PostMapping("/resume/app")
    @ApiOperation("app端生成简历")
    public Result insertResume(@RequestBody Resume resume) {
        return Result.success(workService.addResume(resume));
    }

    @ApiOperation("更新简历")
    @PutMapping("/resume")
    public Result updateResume(@RequestBody Resume resume){
        return Result.success(workService.updateResume(resume));
    }


    @ApiOperation("通过id删除简历")
    @DeleteMapping("/resume")
    public Result deleteResumeById(@RequestParam("id") Integer id){
        return Result.success(workService.deleteResume(id));
    }
}
