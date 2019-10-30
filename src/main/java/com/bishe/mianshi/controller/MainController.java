package com.bishe.mianshi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Kirito
 * @Date 2019/10/20 20:07
 */

@Controller
@RequestMapping("/ms")
public class MainController {
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
