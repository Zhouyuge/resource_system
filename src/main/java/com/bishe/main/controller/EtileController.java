package com.bishe.main.controller;

import cn.hutool.core.map.MapBuilder;
import com.bishe.main.dto.EtileCategoryDto;
import com.bishe.main.dto.EtileDto;
import com.bishe.main.entity.Etile;
import com.bishe.main.entity.EtileWithBLOBs;
import com.bishe.main.service.EtileService;
import com.bishe.main.util.AutoMapperUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author Kirito
 * @Date 2019/11/7 11:51
 */
@RestController
@RequestMapping("/zt/api")
public class EtileController {
    @Autowired
    private EtileService etileService;
    private final int NUM = 20;     //每页获取的专题数

    /**
     * 通过分类no来获取分类下的题目
     *
     * @param no   分类Id
     * @param page 分页页数
     * @return
     */
    @GetMapping("/etile/{no}/{page}")
    @ApiOperation("通过分类no来获取分类下的题目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "no", value = "专题分类Id", required = true, paramType = "int"),
            @ApiImplicitParam(name = "page", value = "页数", required = true, paramType = "int")
    })
    public Map<String, Object> getEtitlesByNo(@PathVariable("no") Integer no, @PathVariable("page") Integer page) {
        Map<String, Object> modelMap = new HashMap<>();
        if (no < 0 && page < 0) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "传入的参数错误");
        }
        List<? extends Etile> etiles = etileService.getEtileDtosByNo(no, page, NUM);    //获取当前页专题
        List<EtileDto> etileDtos = new ArrayList<>();

        for (Etile etile : etiles) {                        //数据转换
            EtileWithBLOBs eb = (EtileWithBLOBs) etile;
            EtileDto ed = new EtileDto();
            AutoMapperUtil.mapping(eb, ed);
            etileDtos.add(ed);
        }
        if (etileDtos.size() > 0) {                 //当转换为出错的情况下
            modelMap.put("success", true);
            modelMap.put("etiles", etileDtos);
        } else {
            modelMap.put("success", false);
            modelMap.put("errNsg", "无专题了嗷`");
        }
        return modelMap;
    }

    /**
     * 通过专题分类和专题分类下的题目别名获取详情
     *
     * @param no
     * @param noAli
     * @return
     */
    @GetMapping("/etile_detail/{no}/{no_ali}")
    @ApiOperation("通过Id来获取专题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "no", value = "专题分类Id", required = true, paramType = "int"),
            @ApiImplicitParam(name = "no_ali", value = "专题别名Id", required = true, paramType = "int")
    })

    public Map<String, Object> getEtileById(@PathVariable("no") Integer no, @PathVariable("no_ali") Integer noAli) {
        Map<String, Object> modelMap = new HashMap<>();
        if (no > 0 && noAli > 0) {
            EtileDto etileDto = etileService.getEtileDtoByAli(no, noAli);
            if (etileDto != null) {
                int size = etileService.getEtileCount(etileDto.getEtileNo());
                modelMap.put("size", size);
                modelMap.put("etile", etileDto);
                modelMap.put("success", true);
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", "没有更多题目了>__<!");
            }
        }
        return modelMap;
    }

    /**
     * 获取全部专题分类
     *
     * @return
     */
    @GetMapping("/categorys")
    @ApiOperation("获取全部专题分类")
    public Map<String, Object> getCategorys() {
        Map<String, Object> modelMap = new HashMap<>();
        List<EtileCategoryDto> etileCategoryDtos = etileService.getEtileCategorys();
        if (etileCategoryDtos.size() < 0) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "未获取到分类信息");
        } else {
            modelMap.put("success", true);
            modelMap.put("etileTypes", etileCategoryDtos);
        }
        return modelMap;
    }

    @GetMapping("/count/{no}")
    @ApiOperation("获取分类Id下的专题数量")
    @ApiImplicitParam(name = "no", value = "分类Id", required = true, paramType = "int")
    public int count(@PathVariable("no") Integer no) {
        return etileService.getEtileCount(no);
    }

}
