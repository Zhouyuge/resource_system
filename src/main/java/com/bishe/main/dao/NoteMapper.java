package com.bishe.main.dao;

import com.bishe.main.entity.Note;

import java.util.HashMap;

public interface NoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Note record);

    Note getNoteByTilteIdAndUserId(HashMap<String, Object> params);

    int updateByPrimaryKey(Note record);
}