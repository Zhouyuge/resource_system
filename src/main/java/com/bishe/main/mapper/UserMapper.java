package com.bishe.main.mapper;

import com.bishe.main.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    int deleteByPrimaryKey(byte[] userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(byte[] userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select " +
            "user_id, user_account, user_name, user_password, create_time " +
            "from tb_user " +
            "where user_account = #{account, jdbcType = VARCHAR}")
    User selectByAccount(@Param("account") String account);
}