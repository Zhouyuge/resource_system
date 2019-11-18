package com.bishe.main.dao;

import com.bishe.main.entity.FType;
import com.bishe.main.entity.FTypeExample;
import java.util.List;

public interface FTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(FType record);

    int insertSelective(FType record);

    List<FType> selectByExample(FTypeExample example);

    FType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(FType record);

    int updateByPrimaryKey(FType record);
}