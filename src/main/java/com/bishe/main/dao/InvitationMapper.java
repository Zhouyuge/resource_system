package com.bishe.main.dao;

import com.bishe.main.entity.Invitation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvitationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Invitation record);

    int insertSelective(Invitation record);

    Invitation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Invitation record);

    int updateByPrimaryKeyWithBLOBs(Invitation record);

    int updateByPrimaryKey(Invitation record);

    List<Invitation> selectInviByType(@Param(value="invitationTypeId") Integer invitationTypeId);

    List<Invitation> selectByUserId(@Param(value="userId") String userId);

    List<Invitation> selectByCirId(@Param(value="cirId")Integer cirId);
}