package com.bishe.main.dao;

import com.bishe.main.entity.CoinWare;
import com.bishe.main.entity.CoinWareExample;

import java.util.List;

public interface CoinWareMapper {
    int deleteByPrimaryKey(Integer coinWareId);

    int insert(CoinWare record);

    int insertSelective(CoinWare record);

    List<CoinWare> selectByExample(CoinWareExample example);

    CoinWare selectByPrimaryKey(Integer coinWareId);

    int updateByPrimaryKeySelective(CoinWare record);

    int updateByPrimaryKey(CoinWare record);
}