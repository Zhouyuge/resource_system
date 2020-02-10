package com.bishe.main.dao;

import com.bishe.main.entity.Factory;
import com.github.pagehelper.Page;

import java.util.List;

public interface FactoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Factory record);

    int insertSelective(Factory record);

    Factory selectByPrimaryKey(Integer id);

    Factory selectByName(String name);

    int updateByPrimaryKeySelective(Factory record);

    int updateByPrimaryKey(Factory record);

    List<Factory> getFactorys();
}