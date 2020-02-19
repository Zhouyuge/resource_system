package com.bishe.main.dao;

import com.bishe.main.entity.PaperTitle;

import java.util.List;

public interface PaperTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PaperTitle record);

    int insertSelective(PaperTitle record);

    PaperTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaperTitle record);

    int updateByPrimaryKey(PaperTitle record);

    List<PaperTitle> getPaperIds();

    List<PaperTitle> getPaperTitlesByPaperId(Integer paperId);
}