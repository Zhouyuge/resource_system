package com.bishe.main.dao;

import com.bishe.main.entity.Moreau;

import java.util.List;

public interface MoreauMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Moreau record);

    int insertSelective(Moreau record);

    Moreau selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Moreau record);

    int updateByPrimaryKey(Moreau record);

    List<Moreau> selectAll();
}