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
    @RequestMapping("/index/mianshi")
    public String test() {
        return "test";
    }

    @RequestMapping("/index/library")
    public String library() {
        return "library";
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

    @RequestMapping("/index/title/s_title")
    public String title() { return "s_title"; }

    @RequestMapping("/index/title/s_title_detail")
    public String titleDetail() {return "s_title_detail";}

    @RequestMapping("/index/study/self_blog")
    public String selfBlog() {return "self_blog";}

    @RequestMapping("/index/study/self_blog_detail")
    public String selfBlogDetail() {return "self_blog_detail";}

    @RequestMapping("/index/self_index")
    public String selfIndex() {
        return "self_index";
    }

    @RequestMapping("/index/book_detail")
    public String bookDeial() { return "book_detail"; }

    @RequestMapping("/index/technology")
    public String technology() { return "technology"; }

    @RequestMapping("/index/tech_detail")
    public String techDetail() { return "tech_detail"; }

    @RequestMapping("/index/circle")
    public String circle() { return "circle"; }

    @RequestMapping("/index/circle_detail")
    public String circleDetail() { return "circle_detail"; }
}
