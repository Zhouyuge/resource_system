package com.bishe.main.service.impl;

import com.bishe.main.dao.ProjectActionMapper;
import com.bishe.main.dao.ProjectDemoMapper;
import com.bishe.main.dao.UserMapper;
import com.bishe.main.entity.ProjectAction;
import com.bishe.main.entity.ProjectDemo;
import com.bishe.main.service.ProjectActionSerivce;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.vo.ProjectDemoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kirito
 * @Date 2020/2/19 12:31
 */
@Service
public class ProjectActionServiceImpl implements ProjectActionSerivce {
    @Autowired
    private ProjectActionMapper projectActionMapper;

    @Autowired
    private ProjectDemoMapper projectDemoMapper;

    @Autowired
    private UserMapper userMapper;
    /**
     * 获取全部/20个实战项目
     * @return
     */
    @Override
    public List<ProjectAction> getProjectActions() {
        List<ProjectAction> projectActionList = projectActionMapper.selectAll().size() > 20 ?
                projectActionMapper.selectAll().subList(0, 20) : projectActionMapper.selectAll();
        projectActionList = projectActionList.stream().map(e -> {
            e.setActionName(e.getActionName().split(" ")[0].length() > 8 ?
                    e.getActionName().split(" ")[0].substring(0, 8) + "..." : e.getActionName().split(" ")[0]);
            return e;
        }).collect(Collectors.toList());
        return projectActionList;
    }

    /**
     * 根据id获取一个实战项目
     * @param id
     * @return
     */
    @Override
    public ProjectAction getProjectActionById(Integer id) {
        return projectActionMapper.selectByPrimaryKey(id);
    }

    /**
     * 插入项目源码记录
     * @param projectDemo
     * @return
     */
    @Override
    public int insertDemo(ProjectDemo projectDemo) {
        return projectDemoMapper.insertSelective(projectDemo);
    }

    /**
     * 获取我上传的源码详情
     * @param projectId
     * @param userId
     * @return
     */
    @Override
    public List<ProjectDemoVO> getMineProjectDemoVOS(Integer projectId, String userId) {
        List<ProjectDemo> projectDemoList = projectDemoMapper.getMineProjectDemos(projectId, userId);
        List<ProjectDemoVO> projectDemoVOList = new ArrayList<>();
        AutoMapperUtil.mappingList(projectDemoList, projectDemoVOList, ProjectDemoVO.class);
        return projectDemoVOList;
    }

    /**
     * 获取不是我上传的源码详情
     * @param projectId
     * @param userId
     * @return
     */
    @Override
    public List<ProjectDemoVO> getNotMineProjectDemoVOS(Integer projectId, String userId) {
        List<ProjectDemo> projectDemoList = projectDemoMapper.getNotMineProjectDemos(projectId, userId);
        List<ProjectDemoVO> projectDemoVOList = new ArrayList<>();
        AutoMapperUtil.mappingList(projectDemoList, projectDemoVOList, ProjectDemoVO.class);
        projectDemoVOList = projectDemoVOList.stream().map(e -> {
            e.setUserHeadPic(e.getUser().getUserHeadPic());
            e.setUserVisualName(e.getUser().getUserVisualName());
            return e;
        }).collect(Collectors.toList());
        return projectDemoVOList;
    }

    /**
     * 根据Id删除项目源码
     * @param demoId
     * @return
     */
    @Override
    public int deleteMineProjectDemo(Integer demoId) {
        return projectDemoMapper.deleteByPrimaryKey(demoId);
    }
}
