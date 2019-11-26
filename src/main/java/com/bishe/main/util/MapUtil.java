package com.bishe.main.util;

import java.util.HashMap;
import java.util.Map;
/**
 * @author Kirito
 * @Date 2019/11/20 16:23
 */
public class MapUtil {
    public static Map<String, Object> errMsg(String errMsg) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", false);
        modelMap.put("errMsg", errMsg);
        return modelMap;
    }

    public static Map<String, Object> sucMsg(Object obj) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", true);
        modelMap.put("data", obj);
        return modelMap;
    }



}
