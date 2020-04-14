package com.bishe.main.dao;

import com.bishe.main.entity.SquareTitle;

import java.util.List;

public interface SquareTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SquareTitle record);

    int insertSelective(SquareTitle record);

    SquareTitle selectByPrimaryKey(Integer id);

    List<SquareTitle> selectAll();

    Integer getCount();

    int updateByPrimaryKeySelective(SquareTitle record);

    int updateByPrimaryKey(SquareTitle record);
}