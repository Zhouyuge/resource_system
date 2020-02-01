package com.bishe.main.dao;

import com.bishe.main.entity.Book;
import com.bishe.main.entity.BookExample;
import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}