package com.bishe.main.dao;

import com.bishe.main.entity.Circle;
import com.bishe.main.entity.CircleExample;
import java.util.List;

public interface CircleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Circle record);

    int insertSelective(Circle record);

    List<Circle> selectByExample(CircleExample example);

    Circle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Circle record);

    int updateByPrimaryKey(Circle record);
}