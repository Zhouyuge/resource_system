package com.bishe.main.controller;

import com.bishe.main.entity.Circle;
import com.bishe.main.service.CircleService;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.util.MapUtil;
import com.bishe.main.vo.CircleVO;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Kirito
 * @Date 2020/2/4 21:11
 */
@RestController
@RequestMapping("/cir/api")
public class CircleController {
    @Autowired
    private CircleService circleService;

    @ApiOperation("分页获取圈子信息列表")
    @GetMapping("/circle/{pageNum}")
    public Map<String, Object> getCircleList(@PathVariable("pageNum") Integer pageNum) {
        try {
            Page<Circle> circles = circleService.getCircleVOs(pageNum);
            List<CircleVO> circleVOS = new ArrayList<>();
            AutoMapperUtil.mappingList(circles, circleVOS, Circle.class);
            Map<String, Object> result =  MapUtil.sucMsg(circleVOS);
            result.put("total", circles.getTotal());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return MapUtil.errMsg("内部错误");
        }
    }

    @ApiOperation("分页分类别获取圈子信息列表")
    @GetMapping("/circle/type/{id}/{pageNum}")
    public Map<String, Object> getCircleListByTypeId(@PathVariable("pageNum") Integer pageNum, @PathVariable("id") Integer typeId) {
        try {
            Page<Circle> circles = circleService.getCircleVOSByTypeId(typeId, pageNum);
            List<CircleVO> circleVOS = new ArrayList<>();
            AutoMapperUtil.mappingList(circles, circleVOS, Circle.class);
            Map<String, Object> result =  MapUtil.sucMsg(circleVOS);
            result.put("total", circles.getTotal());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return MapUtil.errMsg("内部错误");
        }
    }

    @ApiOperation("根据Id获取圈子详情信息")
    @GetMapping("/circle_detail/{id}")
    public Map<String, Object> getCircleVOById(@PathVariable("id") Integer id){
        try {
            CircleVO circle = circleService.getCircleVOById(id);
            return MapUtil.sucMsg(circle);
        } catch (Exception e) {
            e.printStackTrace();
            return MapUtil.errMsg("内部错误");
        }
    }
}
