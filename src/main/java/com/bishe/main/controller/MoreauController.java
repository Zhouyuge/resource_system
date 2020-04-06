package com.bishe.main.controller;

import com.bishe.main.entity.result.Result;
import com.bishe.main.service.MoreauService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kirito
 * @Date 2020/3/31 19:55
 */
@RestController
@RequestMapping("/moreau/api")
public class MoreauController {
    @Autowired
    private MoreauService moreauService;

    @GetMapping("/moreau")
    @ApiOperation("获取面经宝典信息")
    public Result getMoreaus(){
        return Result.success(moreauService.getAllMoreaus());
    }

    @GetMapping("/moreau_chap/{id}")
    @ApiOperation("获取面经宝典章节信息")
    public Result getMoreauChaps(@PathVariable("id") Integer moreauId){
        return Result.success(moreauService.getMoreauVOByMoreauId(moreauId));
    }

    @GetMapping("/moreau_content/{id}")
    @ApiOperation("获取面经宝典详情信息")
    public Result getMoreauContent(@PathVariable("id") Integer id){
        return Result.success(moreauService.getMoreauContent(id));
    }
}
