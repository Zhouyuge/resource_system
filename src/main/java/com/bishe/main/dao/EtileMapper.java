package com.bishe.main.dao;

import com.bishe.main.entity.Etile;
import com.bishe.main.entity.EtileExample;
import com.bishe.main.entity.EtileWithBLOBs;

import java.util.List;

public interface EtileMapper {
    int deleteByPrimaryKey(Integer etileId);

    int insert(EtileWithBLOBs record);

    int insertSelective(EtileWithBLOBs record);

    List<EtileWithBLOBs> selectByExampleWithBLOBs(EtileExample example);

    List<Etile> selectByExample(EtileExample example);

    EtileWithBLOBs selectByPrimaryKey(Integer etileId);

    int updateByPrimaryKeySelective(EtileWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EtileWithBLOBs record);

    int updateByPrimaryKey(Etile record);
}