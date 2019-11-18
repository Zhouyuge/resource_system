package com.bishe.main.dao;

import com.bishe.main.entity.SelectTitle;
import com.bishe.main.entity.SelectTitleExample;
import java.util.List;

public interface SelectTitleMapper {
    int deleteByPrimaryKey(Integer titleId);

    int insert(SelectTitle record);

    int insertSelective(SelectTitle record);

    List<SelectTitle> selectByExample(SelectTitleExample example);

    SelectTitle selectByPrimaryKey(Integer titleId);

    int updateByPrimaryKeySelective(SelectTitle record);

    int updateByPrimaryKey(SelectTitle record);
}