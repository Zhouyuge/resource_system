package com.bishe.main.dao;

import com.bishe.main.entity.BlogCenter;
import com.bishe.main.entity.BlogCenterExample;

import java.util.List;

public interface BlogCenterMapper {
    int deleteByPrimaryKey(Integer blogCenterId);

    int insert(BlogCenter record);

    int insertSelective(BlogCenter record);

    List<BlogCenter> selectByExampleWithBLOBs(BlogCenterExample example);

    List<BlogCenter> selectByExample(BlogCenterExample example);

    BlogCenter selectByPrimaryKey(Integer blogCenterId);

    int updateByPrimaryKeySelective(BlogCenter record);

    int updateByPrimaryKeyWithBLOBs(BlogCenter record);

    int updateByPrimaryKey(BlogCenter record);
}