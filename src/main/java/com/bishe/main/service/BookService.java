package com.bishe.main.service;

import com.bishe.main.vo.BookVO;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/1/22 21:55
 */
public interface BookService {
    List<BookVO> getBookVOList();

    BookVO getBookVOById(Integer id);

}
