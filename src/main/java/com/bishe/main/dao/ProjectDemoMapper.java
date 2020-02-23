package com.bishe.main.dao;

import com.bishe.main.entity.ProjectDemo;

import java.util.List;

public interface ProjectDemoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectDemo record);

    int insertSelective(ProjectDemo record);

    ProjectDemo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectDemo record);

    int updateByPrimaryKey(ProjectDemo record);

    List<ProjectDemo> getMineProjectDemos(Integer projectId, String userId);

    List<ProjectDemo> getNotMineProjectDemos(Integer projectId, String userId);
}