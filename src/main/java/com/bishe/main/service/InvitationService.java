package com.bishe.main.service;

import com.bishe.main.entity.HotTopic;
import com.bishe.main.entity.Invitation;
import com.bishe.main.vo.InvitationVO;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/23 20:01
 */
public interface InvitationService {
    InvitationVO getInvitationVOById(Integer id);

    List<HotTopic> getAllHotTopics();

    List<InvitationVO> getInvitationVOByType(Integer pageNum, Integer invitationType);

    Integer getPage(Integer id);

    Integer insertInvitation(Invitation invitation);

    List<InvitationVO> getInvitationVOByUserId(String userId);

    List<InvitationVO> getInvitationVOByCircleId(Integer cirId);

    Integer deleteInvitation(int id);
}
