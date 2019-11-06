package com.bishe.main.dao;

import com.bishe.main.entity.EtileCategory;
import com.bishe.main.entity.EtileCategoryExample;
import java.util.List;

public interface EtileCategoryMapper {
    int deleteByPrimaryKey(Integer etileCategoryId);

    int insert(EtileCategory record);

    int insertSelective(EtileCategory record);

    List<EtileCategory> selectByExample(EtileCategoryExample example);

    EtileCategory selectByPrimaryKey(Integer etileCategoryId);

    int updateByPrimaryKeySelective(EtileCategory record);

    int updateByPrimaryKey(EtileCategory record);
}