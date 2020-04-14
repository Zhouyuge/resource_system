package com.bishe.main.controller;

import com.bishe.main.entity.Problem;
import com.bishe.main.entity.result.Result;
import com.bishe.main.service.ProblemService;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return Result.success(problemService.getProblem(page));
    }

    @ApiOperation("获取OJ题详情")
    @GetMapping("/pro/{id}")
    public Result<Problem> getProblemById(@PathVariable("id") Long id){
        return Result.success(problemService.getProblemById(id));
    }
}
