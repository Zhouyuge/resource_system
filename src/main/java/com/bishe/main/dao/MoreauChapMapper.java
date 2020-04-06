package com.bishe.main.dao;

import com.bishe.main.entity.MoreauChap;
import com.bishe.main.vo.MoreauVO;

import java.util.List;

public interface MoreauChapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MoreauChap record);

    int insertSelective(MoreauChap record);

    MoreauChap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MoreauChap record);

    int updateByPrimaryKey(MoreauChap record);

    List<MoreauVO> selectByMoreauId(Integer moreauId);
}