package com.bishe.main.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.bishe.main.dto.FTypeDto;
import com.bishe.main.dto.STypeDto;
import com.bishe.main.dto.TitleDto;
import com.bishe.main.entity.User;
import com.bishe.main.entity.result.Result;
import com.bishe.main.service.TitileTypeService;
import com.bishe.main.service.TitleService;
import com.bishe.main.util.MapUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Kirito
 * @Date 2019/11/19 16:45
 * 选择题api
 */
@RestController
@RequestMapping("/st/api")
public class TitleController {
    @Autowired
    private TitileTypeService titleTypeService;

    @Autowired
    private TitleService titleService;
    private static Log log = LogFactory.get(TitleController.class);
    @ApiOperation("获取所有的一级分类")
    @GetMapping("/ftype")
    public Map<String, Object> getFTypes() {
        Map<String, Object> modelMap = new HashMap<>();
        List<FTypeDto> fTypeDtos = titleTypeService.getFTypes();
        if (fTypeDtos != null) {
            modelMap.put("success", true);
            modelMap.put("data", fTypeDtos);
            return modelMap;
        }
        modelMap.put("success", false);
        modelMap.put("errMsg", "后台错误...");
        return modelMap;
    }

    @ApiOperation("获取所有二级分类")
    @GetMapping("/stype/{fId}")
//    @ApiImplicitParam(name = "一级类别Id", value = "fId", required = true, paramType = "int")
    public Map<String, Object> getSTypes(@PathVariable("fId") Integer fId) {
        Map<String, Object> modelMap = new HashMap<>();
        List<STypeDto> sTypeDtos = titleTypeService.getSTypesByFId(fId);
        if (sTypeDtos != null) {
            modelMap.put("success", true);
            modelMap.put("data", sTypeDtos);
            return modelMap;
        }
        modelMap.put("success", false);
        modelMap.put("errMsg", "后台错误...");
        return modelMap;
    }

    @ApiOperation("获取二级分类下20个题")
    @GetMapping("/s_title/{s_type}/{user_id}")
    public Map<String, Object> getTitleDtos (@PathVariable("s_type")Integer sType, @PathVariable("user_id") String userId) {
        List<TitleDto> titleDtos = titleService.getTitleDtos(userId, sType);
        if (titleDtos != null) {
            return MapUtil.sucMsg(titleDtos);
        }
        return MapUtil.errMsg("该分类暂无更多题..");
    }

    @ApiOperation("验证做题答案")
    @PostMapping("/s_title/{user_id}")
    public int checkAns (@RequestBody List<TitleDto> titleDtos, @PathVariable("user_id") String userId) {
        int rNum = titleService.updateTitle(titleDtos, userId);

        return rNum;
    }

    @ApiOperation("获取用户所有错题")
    @GetMapping("/wrong_title/{user_id}")
    public Result<List> getWrongTitles(@PathVariable("user_id")String userId){
        return Result.success(titleService.getWrongDtos(userId));
    }

}
