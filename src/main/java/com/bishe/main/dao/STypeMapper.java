package com.bishe.main.dao;

import com.bishe.main.entity.SType;
import com.bishe.main.entity.STypeExample;
import java.util.List;

public interface STypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(SType record);

    int insertSelective(SType record);

    List<SType> selectByExample(STypeExample example);

    SType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(SType record);

    int updateByPrimaryKey(SType record);
}