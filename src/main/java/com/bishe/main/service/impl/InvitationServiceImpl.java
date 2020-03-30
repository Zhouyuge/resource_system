package com.bishe.main.service.impl;

import com.bishe.main.dao.HotTopicMapper;
import com.bishe.main.dao.InvitationMapper;
import com.bishe.main.dao.UserMapper;
import com.bishe.main.entity.HotTopic;
import com.bishe.main.entity.Invitation;
import com.bishe.main.entity.User;
import com.bishe.main.service.InvitationService;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.vo.InvitationVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kirito
 * @Date 2020/2/23 20:02
 */
@Service
public class InvitationServiceImpl implements InvitationService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InvitationMapper invitationMapper;

    @Autowired
    private HotTopicMapper hotTopicMapper;

    private static Integer pageSize = 10;

    /**
     * 根据id获取帖子详情
     * @param id
     * @return
     */
    @Override
    public InvitationVO getInvitationVOById(Integer id) {
        Invitation invitation =  invitationMapper.selectByPrimaryKey(id);
        InvitationVO invitationVO = new InvitationVO();
        AutoMapperUtil.mapping(invitation, invitationVO);
        User user = userMapper.selectByPrimaryKey(invitation.getUserId());
        invitationVO.setUserImg(user.getUserHeadPic());
        invitationVO.setUserVisualName(user.getUserVisualName());
      //  invitationVO.setLabels(Arrays.asList(invitation.getInvitationLabel().split(" ")));
        return invitationVO;
    }

    /**
     * 获取所有的热门话题
     * @return
     */
    @Override
    public List<HotTopic> getAllHotTopics() {
        return hotTopicMapper.selectAll();
    }

    /**
     * 分页分类获取帖子
     * @param pageNum
     * @param invitationType
     * @return
     */
    @Override
    public List<InvitationVO> getInvitationVOByType(Integer pageNum, Integer invitationType) {
        Page<Invitation> invitations = getInvitation(pageNum, invitationType);
        List<InvitationVO> invitationVOS = new ArrayList<>();
        AutoMapperUtil.mappingList(invitations, invitationVOS, InvitationVO.class);
        invitationVOS = invitationVOS.stream().map(e -> {
           User user = userMapper.selectByPrimaryKey(e.getUserId());
           e.setUserVisualName(user.getUserVisualName());
           e.setUserImg(user.getUserHeadPic());
           e.setSimpleName(e.getUserVisualName().length() > 5 ? e.getUserVisualName().substring(0, 4) + "..." : e.getUserVisualName());
           return e;
        }).collect(Collectors.toList());
        return invitationVOS;
    }

    private Integer page;

    private Page<Invitation> getInvitation(Integer pageNum, Integer invitationType) {
        Page<Invitation> invitationPage = PageHelper.startPage(pageNum, pageSize);
        List<Invitation> invitationList = invitationMapper.selectInviByType(invitationType);
        return invitationPage;
    }

    @Override
    public Integer getPage(Integer id) {
        List<Invitation> invitationList = invitationMapper.selectInviByType(id);
        page = invitationList.size() / pageSize + 1;
        return page;
    }

    @Override
    public Integer insertInvitation(Invitation invitation) {
        return invitationMapper.insertSelective(invitation);
    }

    @Override
    public List<InvitationVO> getInvitationVOByUserId(String userId) {
        List<Invitation> invitations = invitationMapper.selectByUserId(userId);
        List<InvitationVO> invitationVOS = new ArrayList<>();
        AutoMapperUtil.mappingList(invitations, invitationVOS, InvitationVO.class);
        invitationVOS = invitationVOS.stream().map(e -> {
            User user = userMapper.selectByPrimaryKey(e.getUserId());
            e.setUserVisualName(user.getUserVisualName());
            e.setUserImg(user.getUserHeadPic());
            e.setSimpleName(e.getUserVisualName().length() > 5 ? e.getUserVisualName().substring(0, 4) + "..." : e.getUserVisualName());
            return e;
        }).collect(Collectors.toList());
        return invitationVOS;
    }

    @Override
    public List<InvitationVO> getInvitationVOByCircleId(Integer cirId) {
        List<Invitation> invitations = invitationMapper.selectByCirId(cirId);
        List<InvitationVO> invitationVOS = new ArrayList<>();
        AutoMapperUtil.mappingList(invitations, invitationVOS, InvitationVO.class);
        invitationVOS = invitationVOS.stream().map(e -> {
            User user = userMapper.selectByPrimaryKey(e.getUserId());
            e.setUserVisualName(user.getUserVisualName());
            e.setUserImg(user.getUserHeadPic());
            e.setSimpleName(e.getUserVisualName().length() > 5 ? e.getUserVisualName().substring(0, 4) + "..." : e.getUserVisualName());
            return e;
        }).collect(Collectors.toList());
        return invitationVOS;
    }

    @Override
    public Integer deleteInvitation(int id) {
        return invitationMapper.deleteByPrimaryKey(id);
    }
}
