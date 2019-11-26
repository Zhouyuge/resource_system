package com.bishe.main.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.bishe.main.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;

/**
 * @author Kirito
 * @Date 2019/11/25 11:51
 */
@RestController
@RequestMapping("/user/api")
public class UserController {
    private static Log log = LogFactory.get(UserController.class);
    @GetMapping ("/user")
    public User getUser (HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        log.warn("--->" + user.toString());
        return user;
    }
}
