package com.bishe.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Kirito
 * @Date 2019/10/20 20:07
 */

@Controller
@RequestMapping("/bs")
public class MainController {
    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/index/topics")
    public String topics() {
        return "topics";
    }

    @RequestMapping("/index/topics/etiles")
    public String etiles() {
        return "etile";
    }

    @RequestMapping("/index/topics/detail_etile")
    public String detailEtile() {
        return "etile_question";
    }

    @RequestMapping("/index/study/blog")
    public String blog() {
        return "blog";
    }

    @RequestMapping("/index/study/detail_blog")
    public String blogDetail() {
        return "detail_blog";
    }

    @RequestMapping("/index/find/coin_ware")
    public String coinWare() {
        return "coin_ware";
    }
}
