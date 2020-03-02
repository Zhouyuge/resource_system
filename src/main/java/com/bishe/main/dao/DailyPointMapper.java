package com.bishe.main.dao;

import com.bishe.main.entity.DailyPoint;
import com.bishe.main.vo.DailyPointVO;

import java.util.List;

public interface DailyPointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DailyPoint record);

    int insertSelective(DailyPoint record);

    DailyPoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DailyPoint record);

    int updateByPrimaryKey(DailyPoint record);

    List<DailyPointVO> selectAll();
}