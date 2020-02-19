package com.bishe.main.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.bishe.main.service.UniversityService;
import com.bishe.main.util.MapUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Kirito
 * @Date 2020/2/13 19:45
 */
@RestController
@RequestMapping("/uni/api")
public class UniversityController {
    @Autowired
    private UniversityService universityService;

    private static final Log log = LogFactory.get(UniversityController.class);

    @ApiOperation("获取城市下的大学信息列表")
    @GetMapping("/unis/{city_name}")
    public Map<String, Object> getUnisByCityId(@PathVariable("city_name") String cityName) {
        try {
            return MapUtil.sucMsg(universityService.getUniversityVOsByCityId(cityName));
        }catch (Exception e) {
            log.error("查询" + cityName + "城市下大学错误", e);
            e.printStackTrace();
            return MapUtil.errMsg("内部错误");
        }
    }

    @ApiOperation("获取id下的大学信息")
    @GetMapping("/uni/{id}")
    public Map<String, Object> getUniById(@PathVariable("id") Integer id){
        try {
            return MapUtil.sucMsg(universityService.getUniVersityById(id));
        }catch (Exception e) {
            log.error("查询id为: " + id + "下大学错误", e);
            e.printStackTrace();
            return MapUtil.errMsg("内部错误");
        }
    }

    @ApiOperation("获取大学下的所有考研试卷")
    @GetMapping("/paper/{uniId}")
    public Map<String, Object> getPapers(@PathVariable("uniId") Integer uniId){
        try {
            return MapUtil.sucMsg(universityService.getPapersByUniId(uniId));
        }catch (Exception e) {
            e.printStackTrace();
            log.error("获取大学id为：" + uniId + "试卷错误", e);
            return MapUtil.errMsg("内部错误");
        }
    }

    @ApiOperation("分页获取试卷试题")
    @GetMapping("/paper_titles/{paper_id}/{page_num}")
    public Map<String, Object> getPapers(@PathVariable("paper_id") Integer paperId, @PathVariable("page_num") Integer pageNum) {
        try {
            return MapUtil.sucMsg(universityService.getPaperTitles(paperId, pageNum));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("分页错误", e);
            return MapUtil.errMsg("内部错误");
        }
    }

    @ApiOperation("根据id获取试题详情")
    @GetMapping("/paper_title/{id}")
    public Map<String, Object> getPaperTitle(@PathVariable("id") Integer id) {
        try {
            return MapUtil.sucMsg(universityService.getPaperTitleById(id));
        }catch (Exception e) {
            e.printStackTrace();
            log.error("获取试题id为：" + id + "错误", e);
            return MapUtil.errMsg("内部错误");
        }
    }
}
