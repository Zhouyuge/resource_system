package com.bishe.main.dao;

import com.bishe.main.entity.Etile;
import com.bishe.main.entity.EtileExample;
import java.util.List;

public interface EtileMapper {
    int deleteByPrimaryKey(Integer etileId);

    int insert(Etile record);

    int insertSelective(Etile record);

    List<Etile> selectByExampleWithBLOBs(EtileExample example);

    List<Etile> selectByExample(EtileExample example);

    Etile selectByPrimaryKey(Integer etileId);

    int updateByPrimaryKeySelective(Etile record);

    int updateByPrimaryKeyWithBLOBs(Etile record);

    int updateByPrimaryKey(Etile record);
}