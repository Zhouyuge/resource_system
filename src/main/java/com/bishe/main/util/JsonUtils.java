package com.bishe.main.util;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;

/**
 * @author Kirito
 * @Date 2019/11/14 17:41
 */
public class JsonUtils {

    public static JSON objToJson(Object obj){
        String json = com.alibaba.fastjson.JSON.toJSONString(obj);
        JSON jsons = JSONUtil.parse(json);

        return jsons;
    }
}
