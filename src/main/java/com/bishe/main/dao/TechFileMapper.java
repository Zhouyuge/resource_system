package com.bishe.main.dao;

import com.bishe.main.entity.TechFile;
import com.bishe.main.entity.TechFileExample;
import java.util.List;

public interface TechFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TechFile record);

    int insertSelective(TechFile record);

    List<TechFile> selectByExample(TechFileExample example);

    TechFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TechFile record);

    int updateByPrimaryKey(TechFile record);
}