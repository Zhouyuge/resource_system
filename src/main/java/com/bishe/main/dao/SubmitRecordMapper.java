package com.bishe.main.dao;

import com.bishe.main.entity.SubmitRecord;
import org.apache.ibatis.annotations.Select;

public interface SubmitRecordMapper {
    int deleteByPrimaryKey(Long submitId);

    int insert(SubmitRecord record);

    int insertSelective(SubmitRecord record);

    SubmitRecord selectByPrimaryKey(Long submitId);

    int updateByPrimaryKeySelective(SubmitRecord record);

    int updateByPrimaryKeyWithBLOBs(SubmitRecord record);

    int updateByPrimaryKey(SubmitRecord record);

    @Select("select count(*) from submit_record")
    Long getSubmitCount();
}