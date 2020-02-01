package com.bishe.main.dao;

import com.bishe.main.entity.Resume;
import com.bishe.main.entity.ResumeExample;
import java.util.List;

public interface ResumeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resume record);

    int insertSelective(Resume record);

    List<Resume> selectByExample(ResumeExample example);

    Resume selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);
}