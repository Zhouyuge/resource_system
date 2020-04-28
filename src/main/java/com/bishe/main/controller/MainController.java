package com.bishe.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Kirito
 * @Date 2020/4/24 9:03
 */
@Controller
@RequestMapping("/system")
public class MainController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/index/category")
    public String category(){
        return "category";
    }
    @RequestMapping("/index/material")
    public String material(){
        return "material";
    }
    @RequestMapping("/index/stock")
    public String stock(){
        return "stock";
    }
}
