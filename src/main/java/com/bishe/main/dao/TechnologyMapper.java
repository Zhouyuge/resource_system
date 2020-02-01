package com.bishe.main.dao;

import com.bishe.main.entity.Technology;
import com.bishe.main.entity.TechnologyExample;
import java.util.List;

public interface TechnologyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Technology record);

    int insertSelective(Technology record);

    List<Technology> selectByExample(TechnologyExample example);

    Technology selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);
}