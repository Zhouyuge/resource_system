package com.bishe.main.controller;

import com.bishe.main.dto.CoinWareDto;
import com.bishe.main.service.CoinWareService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author Kirito
 * @Date 2019/11/13 14:08
 * 牛币商城控制器
 */
@RestController
@RequestMapping("/cw/api")
public class CoinWareController {
    @Autowired
    private CoinWareService coinWareService;

    /**
     * 获取所有牛币商城商品信息
     *
     * @return
     */
    @GetMapping("/coin_wares")
    @ApiOperation("获取所有牛币商城商品信息")
    public Map<String, Object> getCoinWares() {
        Map<String, Object> modelMap = new HashMap<>();

        List<CoinWareDto> coinWareDtoList = coinWareService.getCoinWareDtos();
        if (coinWareDtoList.size() > 0) {
            modelMap.put("success", true);
            modelMap.put("ware", coinWareDtoList);
            return modelMap;
        }
        modelMap.put("success", false);
        modelMap.put("errMsg", "后台错误X_X！！");
        return modelMap;
    }


    @ApiOperation("通过Id获取商品信息")
    @GetMapping("/ware/{ware_no}")
    public Map<String, Object> getCoinWareById(@PathVariable("ware_no") Integer id) {
        Map<String, Object> modelMap = new HashMap<>();
        CoinWareDto coinWareDto = coinWareService.getCoinWareDtoById(id);
        if (coinWareDto != null) {
            modelMap.put("success", true);
            modelMap.put("ware", coinWareDto);
        } else {
            modelMap.put("errMsg", "id传入错误、、");
            modelMap.put("success", false);
        }

        return modelMap;
    }
}
