package com.bishe.mianshi.controller;

import com.bishe.mianshi.util.FileUtils;
import io.swagger.annotations.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSourceExtensionsKt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kirito
 * @Date 2019/10/30 15:17
 */
@RestController
@RequestMapping("/ms/api")
public class MianShiController {
    /**
     * 获取面试文章列表
     * @return
     */
    @GetMapping("/getarticle/id")
    @ApiOperation("获取面经文章")
    @ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "int")
    public Map<String, Object> getArticle(@PathVariable("id") int id){
        Map<String, Object> resultMap = new HashMap<>();
        File file = new File("D://面试题//Java面试宝典导读//");
        //如果这个路径是文件夹
        if(file.isDirectory()){
            //获取路径下的文件夹
            File[] files = file.listFiles();
 loop:           for(File f : files){
                if(f.isDirectory()){
                    for(File f1 : f.listFiles()){
                        if(f1.getName().split("\\.")[0].equals(id + "")){
                            resultMap.put("success", true); //提取文章成功
                            String article = FileUtils.readFileContent(f);
                            resultMap.put("article", article);  //将文章放入返回的map中
                            break loop;
                        }
                        continue ;
                    }
                }
            }
        }

        if(resultMap.size() == 0){
            resultMap.put("success", false);
            resultMap.put("errMsg", "您已经阅读完啦~");
        }
        return resultMap;
    }
}
