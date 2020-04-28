package com.bishe.main.controller;

import com.bishe.main.entity.User;
import com.bishe.main.entity.result.Result;
import com.bishe.main.service.UserService;
import com.bishe.main.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Kirito
 * @Date 2020/4/24 10:00
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody UserVO user, HttpServletRequest request){
        User realUser = userService.login(user);
        // 屏蔽用户密码
        realUser.setUserPassword("");
        request.getSession().setAttribute("user", realUser);
        return Result.success("登录成功");
    }
}
