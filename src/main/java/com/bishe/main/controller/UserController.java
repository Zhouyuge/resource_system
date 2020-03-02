package com.bishe.main.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.bishe.main.entity.User;
import com.bishe.main.entity.result.CodeMsg;
import com.bishe.main.entity.result.Result;
import com.bishe.main.service.UserService;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.util.MapUtil;
import com.bishe.main.vo.DailyPointVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
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

    @ApiOperation("上传图片")
    @PostMapping("/upload")
    public Result<Map> uploadPicture(@RequestBody MultipartFile file) {
        Result<Map> result = null;
        if ( ! file.isEmpty()) {
            Map<String, Object> data = new HashMap<>();
            try {
                String filePath = "D://niuke//daily_img//";
                File file1 = new File(filePath);
                if( !file1.exists()){
                    file1.mkdirs();
                }
                filePath += file.getOriginalFilename();

                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                out.write(file.getBytes());
                out.close();

                data.put("src", "http://localhost:10086/img/daily_img/" + file.getOriginalFilename());
                result = new Result<Map>(data, "", 0);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @ApiOperation("获取所有签到信息")
    @GetMapping("/daily_points/{page_num}")
    public Result<List> getAllDailyPoints(@PathVariable("page_num") Integer pageNum){
        Result result = Result.success(userService.getAllDailyPointVO(pageNum));
        result.setPage(userService.pageCount());
        return result;
    }

    @ApiOperation("插入签到信息")
    @PostMapping("/daily_point")
    public Result insertDailyPoint(@RequestBody DailyPointVO dailyPointVO, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        String userId = user.getUserId();
        return Result.success(userService.addDailyPoint(dailyPointVO, userId));
    }
}
