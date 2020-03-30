package com.bishe.main.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.bishe.main.service.PostService;
import com.bishe.main.util.MapUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kirito
 * @Date 2020/2/10 15:46
 */
@RestController
@RequestMapping("/post/api")
public class PostController {
    @Autowired
    private PostService postService;

    private static Log log = LogFactory.get(PostController.class);
    @GetMapping("/post/{pageNum}")
    @ApiOperation("分页获取所有岗位详情")
    public Map<String, Object> getPosts(@PathVariable("pageNum")Integer pageNum) {
        Map<String, Object> modelMap = new HashMap<>();
        try{
            modelMap = MapUtil.sucMsg(postService.getPostVOs(pageNum));
            modelMap.put("pages", postService.getPageNums(null));
            return modelMap;
        }catch (Exception e) {
            e.printStackTrace();
            log.error("岗位查询错误", e.getMessage());
            return MapUtil.errMsg("内部错误");
        }
    }

    @ApiOperation("根据类别id获取岗位详情")
    @GetMapping("/post_type/{typeId}/{pageNum}")
    public Map<String, Object> getPostListByType(@PathVariable("typeId") Integer typeId, @PathVariable("pageNum") Integer pageNum){
        Map<String, Object> resultMap = new HashMap<>();
        try{
            resultMap = MapUtil.sucMsg(postService.getPostVOsByTypeId(typeId, pageNum));
            resultMap.put("pages", postService.getPageNums(typeId));
            return resultMap;
        }catch (Exception e) {
            log.error("岗位查询错误", e.getMessage());
            e.printStackTrace();
            return MapUtil.errMsg("内部错误");
        }
    }

    @ApiOperation("根据id获取岗位详情")
    @GetMapping("/post_detail/{id}")
    public Map<String, Object> getPostVoById(@PathVariable("id") Integer id){
        try{
            return MapUtil.sucMsg(postService.getPostVOById(id));
        }catch (Exception e) {
            e.printStackTrace();
            log.error("岗位查询错误", "id=" + id);
            return MapUtil.errMsg("内部错误");
        }
    }

    @ApiOperation("获取公司下所有的岗位列表")
    @GetMapping("/fac_post/{factoryId}")
    public Map<String, Object> getPostVOsByFacotyId(@PathVariable Integer factoryId){
        try{
            return MapUtil.sucMsg(postService.getPostVOByFactoryId(factoryId));
        }catch (Exception e) {
            e.printStackTrace();
            log.error("岗位查询错误", "factoryId=" + factoryId);
            return MapUtil.errMsg("内部错误");
        }
    }
}
