package com.bishe.main.service;

import com.bishe.main.entity.ProjectAction;
import com.bishe.main.entity.ProjectDemo;
import com.bishe.main.vo.ProjectDemoVO;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/19 12:31
 */
public interface ProjectActionSerivce {

    List<ProjectAction> getProjectActions();

    ProjectAction getProjectActionById(Integer id);

    int insertDemo(ProjectDemo projectDemo);

    List<ProjectDemoVO> getMineProjectDemoVOS(Integer projectId, String userId);

    List<ProjectDemoVO> getNotMineProjectDemoVOS(Integer projectId, String userId);

    int deleteMineProjectDemo(Integer demoId);
}

