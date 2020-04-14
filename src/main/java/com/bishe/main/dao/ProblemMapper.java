package com.bishe.main.dao;

import com.bishe.main.entity.Problem;
import com.bishe.main.entity.ProblemWithBLOBs;

import java.util.List;

public interface ProblemMapper {
    int deleteByPrimaryKey(Long problemId);

    int insert(ProblemWithBLOBs record);

    int insertSelective(ProblemWithBLOBs record);

    ProblemWithBLOBs selectByPrimaryKey(Long problemId);

    int updateByPrimaryKeySelective(ProblemWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProblemWithBLOBs record);

    int updateByPrimaryKey(Problem record);

    List<Problem> getProblem();

}