package com.bishe.main.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.bishe.main.entity.User;
import com.bishe.main.service.UserService;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.util.MapUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Kirito
 * @Date 2019/11/25 11:51
 */
@RestController
@RequestMapping("/user/api")
public class UserController {
    @Autowired
    private UserService userService;
    private static Log log = LogFactory.get(UserController.class);
    @ApiOperation("获取用户")
    @GetMapping ("/user")
    public User getUser (HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        log.warn("--->" + user.toString());
        return user;
    }

    @ApiOperation("获取用户Id")
    @GetMapping("/user_id")
    public String getUserId (HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return user.getUserId();
    }

    @ApiOperation("更改用户基本信息")
    @PutMapping ("/user")
    public String updateUser(HttpServletRequest request) throws IOException {
        String userStr = request.getParameter("user");
        RestTemplate restTemplate = new RestTemplate();
        String token = (String)request.getSession().getAttribute("token");
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("user", userStr);
        modelMap.put("token", token);
        restTemplate.put("http://localhost:8081/login/api/user/{user}/{token}", null, modelMap);
        String str = userService.queryUserByToken(token);
        //TODO 待改善...
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(str, User.class);
        request.getSession().setAttribute("user", user);
        return "修改成功！";
    }
}
