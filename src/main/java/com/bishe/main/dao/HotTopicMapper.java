package com.bishe.main.dao;

import com.bishe.main.entity.HotTopic;

import java.util.List;

public interface HotTopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HotTopic record);

    int insertSelective(HotTopic record);

    HotTopic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HotTopic record);

    int updateByPrimaryKey(HotTopic record);

    List<HotTopic> selectAll();
}