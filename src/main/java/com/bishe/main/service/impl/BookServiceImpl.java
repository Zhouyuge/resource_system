package com.bishe.main.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.bishe.main.dao.BookMapper;
import com.bishe.main.entity.Book;
import com.bishe.main.entity.BookExample;
import com.bishe.main.service.BookService;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirito
 * @Date 2020/1/22 21:55
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookVO> getBookVOList() {
        List<BookVO> bookVOS = new ArrayList<>();
        List<Book> books = bookMapper.selectByExample(new BookExample());
        if(!ObjectUtil.isEmpty(books)) {
            AutoMapperUtil.mappingList(books, bookVOS, BookVO.class);
            return bookVOS.size() > 10 ? bookVOS.subList(0, 10) : bookVOS;
        }
        return null;
    }

    @Override
    public BookVO getBookVOById(Integer id) {
        BookVO bookVO = new BookVO();
        Book book = bookMapper.selectByPrimaryKey(id);
        if(ObjectUtil.isNotEmpty(book)) {
            AutoMapperUtil.mapping(book, bookVO);
            return bookVO;
        }
        return null;
    }
}
