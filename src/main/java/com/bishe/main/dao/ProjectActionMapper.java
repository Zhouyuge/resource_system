package com.bishe.main.dao;

import com.bishe.main.entity.ProjectAction;

import java.util.List;

public interface ProjectActionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectAction record);

    int insertSelective(ProjectAction record);

    ProjectAction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectAction record);

    int updateByPrimaryKey(ProjectAction record);

    List<ProjectAction> selectAll();
}