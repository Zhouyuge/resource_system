package com.bishe.main.dao;

import com.bishe.main.entity.OjRecord;
import com.bishe.main.entity.OjRecordWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OjRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OjRecordWithBLOBs record);

    int insertSelective(OjRecordWithBLOBs record);

    OjRecordWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OjRecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OjRecordWithBLOBs record);

    int updateByPrimaryKey(OjRecord record);

    @Select("select id, user_id, right_problem_id, do_problem_id " +
            "from tb_oj_record " +
            "where user_id = #{userId, jdbcType = VARCHAR}")
    OjRecordWithBLOBs selectByUserId(@Param("userId") String userId);
}