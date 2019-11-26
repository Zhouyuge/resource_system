package com.bishe.main.dao;

import com.bishe.main.entity.TakeTitle;
import com.bishe.main.entity.TakeTitleExample;
import com.bishe.main.entity.TakeTitleWithBLOBs;
import java.util.List;

public interface TakeTitleMapper {
    int deleteByPrimaryKey(Integer takeId);

    int insert(TakeTitleWithBLOBs record);

    int insertSelective(TakeTitleWithBLOBs record);

    List<TakeTitleWithBLOBs> selectByExampleWithBLOBs(TakeTitleExample example);

    List<TakeTitle> selectByExample(TakeTitleExample example);

    TakeTitleWithBLOBs selectByPrimaryKey(Integer takeId);

    int updateByPrimaryKeySelective(TakeTitleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TakeTitleWithBLOBs record);

    int updateByPrimaryKey(TakeTitle record);
}