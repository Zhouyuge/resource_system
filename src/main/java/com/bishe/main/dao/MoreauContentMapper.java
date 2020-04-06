package com.bishe.main.dao;

import com.bishe.main.entity.MoreauContent;

public interface MoreauContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MoreauContent record);

    int insertSelective(MoreauContent record);

    MoreauContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MoreauContent record);

    int updateByPrimaryKeyWithBLOBs(MoreauContent record);

    int updateByPrimaryKey(MoreauContent record);
}