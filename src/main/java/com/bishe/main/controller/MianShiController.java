package com.bishe.main.controller;

import com.bishe.main.util.FileUtils;
import com.github.pagehelper.StringUtil;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.*;

/**
 * @author Kirito
 * @Date 2019/10/30 15:17
 */
@RestController
@RequestMapping("/ms/api")
public class MianShiController {
    /**
     * 获取面试文章列表
     *
     * @return
     */
    @GetMapping("/getarticle")
    @ApiOperation("获取面经文章")
    @ApiImplicitParam(name = "id", value = "面经Id", required = true, dataType = "String")
    public Map<String, Object> getArticle(@RequestParam(value = "id", required = true) String id, @RequestParam(value = "title", required = true) String title) {
        Map<String, Object> resultMap = new HashMap<>();

        if (StringUtil.isEmpty(id) && Integer.parseInt(id) <= 0) {
            resultMap.put("success", false);
            resultMap.put("errMsg", "当前文章不存在");
            return resultMap;
        }

        File file = new File("D://面试题//" + title + "//");
        //如果这个路径是文件夹
        if (file.isDirectory()) {
            //获取路径下的文件夹
            File[] files = file.listFiles();
            loop:
            for (File f : files) {
                if (f.isDirectory()) {
                    for (File f1 : f.listFiles()) {
                        if ((f1.getName().split("\\D")[0] + "." + f1.getName().split("\\D")[1]).equals(id)) {
                            resultMap.put("success", true); //提取文章成功
                            String article = FileUtils.readFileContent(f1);
                            if (article != null) {
                                resultMap.put("success", true); //提取文章成功
                                resultMap.put("article", article);  //将文章放入返回的map中
                            } else {
                                resultMap.put("success", false); //提取文章成功
                                resultMap.put("errMsg", "空白文章...");  //将文章放入返回的map中
                            }
                            break loop;
                        }
                        continue;
                    }
                }
            }
        }

        if (resultMap.size() == 0) {
            resultMap.put("success", false);
            resultMap.put("errMsg", "您已经阅读完啦~");
        }
        return resultMap;
    }


    /**
     * 获取目录标题
     *
     * @return
     */
    @GetMapping("/gettitles")
    public Map<String, Object> getTitles(@RequestParam(value = "title", required = true) String direct) {
        String str = "D://面试题//" + direct + "//";
        Map<String, Object> modelMap = new HashMap<>();
        File dir = new File(str);
        Map<String, Object> titles = new TreeMap<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return Integer.parseInt(o1.split("\\D")[0])
                                - Integer.parseInt(o2.split("\\D")[0]);
                    }
                }
        );   //使用map适用存储
        for (File f : dir.listFiles()) {
            List<String> title = null;              //存储个大标题目录下的文件名
            if (f != null) {
                title = new ArrayList<>();
                for (File f1 : f.listFiles()) {
                    title.add(f1.getName().split("\\.txt")[0]);
                }
                Collections.sort(title, (t1, t2) -> {              //lambda表达式定义Comparator内部类排序规则
                    //取出文件名中的排序数字
                    int diff = Integer.parseInt(t1.split("\\D")[1]) - Integer.parseInt(t2.split("\\D")[1]);
                    if (diff > 0) {
                        return 1;
                    } else if (diff < 0) {
                        return -1;
                    }
                    return 0;
                });
                titles.put(f.getName(), title);
            }
        }

        modelMap.put("titles", titles);                         //将一级标题存储到map中
        return modelMap;
    }

}
