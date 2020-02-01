package com.bishe.main.controller;

import cn.hutool.core.util.ObjectUtil;
import com.bishe.main.service.BookService;
import com.bishe.main.util.MapUtil;
import com.bishe.main.vo.BookVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Kirito
 * @Date 2020/1/22 21:56
 */
@RestController
@RequestMapping("/lib/api")
public class BookController {
    @Autowired
    private BookService bookService;

    @ApiOperation("获取所有book信息")
    @GetMapping("/book")
    public Map<String, Object> getBookInfos() {
        Map<String, Object> resultMap = new HashMap<>();
        List<BookVO> bookVOS = bookService.getBookVOList();
        if(ObjectUtil.isNotEmpty(bookVOS)) {
            resultMap = MapUtil.sucMsg(bookVOS);
        } else {
            resultMap = MapUtil.errMsg("book信息为空");
        }
        return resultMap;
    }

    @ApiOperation("获取所有book信息")
    @GetMapping("/book/{id}")
    public Map<String, Object> getBookById(@PathVariable("id") Integer id) {
        Map<String, Object> resultMap = new HashMap<>();
        BookVO bookVO = bookService.getBookVOById(id);
        if(ObjectUtil.isNotEmpty(bookVO)) {
            resultMap = MapUtil.sucMsg(bookVO);
        } else {
            resultMap = MapUtil.errMsg("book信息为空");
        }
        return resultMap;
    }


}
