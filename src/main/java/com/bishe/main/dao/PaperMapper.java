package com.bishe.main.dao;

import com.bishe.main.entity.Paper;

import java.util.List;

public interface PaperMapper {
    List<Paper> getPapers();

    int deleteByPrimaryKey(Integer id);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);

    List<Paper> getPapersByUni(Integer uniId);
}