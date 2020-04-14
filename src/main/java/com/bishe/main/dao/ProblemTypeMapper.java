package com.bishe.main.dao;

import com.bishe.main.entity.ProblemType;

public interface ProblemTypeMapper {
    int deleteByPrimaryKey(Integer problemTypeId);

    int insert(ProblemType record);

    int insertSelective(ProblemType record);

    ProblemType selectByPrimaryKey(Integer problemTypeId);

    int updateByPrimaryKeySelective(ProblemType record);

    int updateByPrimaryKey(ProblemType record);
}