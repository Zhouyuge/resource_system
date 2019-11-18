package com.bishe.main.controller;

import com.bishe.main.dto.BlogContentDto;
import com.bishe.main.dto.BlogDto;
import com.bishe.main.entity.BlogCenter;
import com.bishe.main.service.BlogCenterService;
import com.bishe.main.util.AutoMapperUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author Kirito
 * @Date 2019/11/12 11:55
 * 博客专栏控制器
 */
@RestController
@RequestMapping("/bc/api")
public class BlogController {
    @Autowired
    private BlogCenterService blogCenterService;

    @GetMapping("/blog/{page}")
    @ApiOperation("分页获取专栏博客简介")
    @ApiImplicitParam(name = "分页", value = "page", required = true, paramType = "int")
    public Map getBlogDtos(@PathVariable Integer page) {
        Map<String, Object> modelMap = new HashMap<>();
        List<BlogCenter> blogCenters = blogCenterService.getBlogDtos(page, 0);
        if (blogCenters != null) {
            List<BlogDto> blogDtos = new ArrayList<>();
            AutoMapperUtil.mappingList(blogCenters, blogDtos, BlogDto.class);
            if (blogDtos.size() > 0) {
                modelMap.put("success", true);
                modelMap.put("blogDtos", blogDtos);
                modelMap.put("pages", 2);
                return modelMap;
            } else {
                System.out.println("----------------> 转换失败！");
            }
        }

        modelMap.put("success", false);
        modelMap.put("errMsg", "内部错误！");
        return modelMap;
    }

    @GetMapping("/blog_detail/{id}")
    @ApiOperation("根据Id获取博客详情")
    @ApiImplicitParam(name = "博客Id", value = "id", required = true, paramType = "int")
    public Map<String, Object> getBlogContent(@PathVariable("id") Integer id) {
        Map<String, Object> modelMap = new HashMap<>();
        if (id != null) {
            BlogContentDto blogContentDto = blogCenterService.getBlogContentDtoById(id);
            if (blogContentDto != null) {
                modelMap.put("blog", blogContentDto);
                modelMap.put("success", true);
                return modelMap;
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", "读取不到该博客！");
                return modelMap;
            }
        }
        modelMap.put("success", false);
        modelMap.put("errMsg", "参数错误...");
        return modelMap;
    }

}
