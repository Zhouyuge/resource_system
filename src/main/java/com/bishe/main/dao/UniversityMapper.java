package com.bishe.main.dao;

import com.bishe.main.entity.University;

import java.util.List;

public interface UniversityMapper {
    int deleteByPrimaryKey(Integer id);

    List<University> getByCityId(Integer cityId);

    int insert(University record);

    int insertSelective(University record);

    University selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(University record);

    int updateByPrimaryKey(University record);
}