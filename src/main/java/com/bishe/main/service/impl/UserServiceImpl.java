package com.bishe.main.service.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.bishe.main.service.RedisService;
import com.bishe.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kirito
 * @Date 2019/11/15 16:23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisService redisService;

    private static final String REDIS_USER_SESSION_KEY = "REDIS_USER_SESSION";

    private static final String SSO_SESSION_EXPIRE = "30";

    @Override
    public void logout(String token){
        redisService.remove(REDIS_USER_SESSION_KEY + ":" + token);
    }

    @Override
    public String queryUserByToken(String token) {
        // 根据token从redis中查询用户信息
        JSONObject json = (JSONObject)redisService.get(REDIS_USER_SESSION_KEY + ":" + token);
        // 判断是否为空
        if (json == null) {
            return null;
        }

        String jsonStr = JSONUtil.toJsonStr(json);
        // 更新过期时间
        redisService.remove(REDIS_USER_SESSION_KEY + ":" + token);
        redisService.set(REDIS_USER_SESSION_KEY + ":" + token, JSONUtil.parse(json), Long.parseLong(SSO_SESSION_EXPIRE));

        System.err.println(jsonStr);
        return jsonStr;
    }
}
