package com.bishe.main.controller;

import com.bishe.main.entity.Invitation;
import com.bishe.main.entity.result.Result;
import com.bishe.main.service.InvitationService;
import com.bishe.main.vo.InvitationVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/23 20:10
 */
@RestController
@RequestMapping("/invi/api")
public class InvitationController {
    @Autowired
    private InvitationService invitationService;

    @ApiOperation("根据id获取帖子详情")
    @GetMapping("/invitation/{invi_id}")
    public Result<InvitationVO> getInvitationById(@PathVariable("invi_id") Integer id) {
        return Result.success(invitationService.getInvitationVOById(id));
    }

    @ApiOperation("获取所有的热门话题")
    @GetMapping("/hot")
    public Result<List> getAllHotTopics() {
        return Result.success(invitationService.getAllHotTopics());
    }

    @ApiOperation("分页分类获取帖子")
    @GetMapping("/invis/{pageNum}/{typeId}")
    public Result<List> getInvitationByTypeId(@PathVariable("pageNum") Integer pageNum, @PathVariable("typeId") Integer typeId) {
        if(typeId == 0){
            typeId = null;
        }
        Result<List> result = Result.success(invitationService.getInvitationVOByType(pageNum, typeId));
        result.setPage(invitationService.getPage(typeId));
        return result;
    }

    @ApiOperation("添加帖子")
    @PostMapping("/invis")
    public Result addInvitations(@RequestBody Invitation invitation){
        return Result.success(invitationService.insertInvitation(invitation));
    }

    @ApiOperation("获取用户的帖子")
    @GetMapping("/invis_user/{user_id}")
    public Result<List> getInvitationByUserId(@PathVariable("user_id")String userId){
        return Result.success(invitationService.getInvitationVOByUserId(userId));
    }

    @ApiOperation("删除帖子")
    @DeleteMapping("/invis")
    public Result deleteInvitation(@RequestParam("id") Integer id){
        return Result.success(invitationService.deleteInvitation(id));
    }

    @ApiOperation("获取圈子下的帖子")
    @GetMapping("/invis_cir/{cir_id}")
    public Result<List> getInvitationByCirId(@PathVariable("cir_id") Integer cirId){
        return Result.success(invitationService.getInvitationVOByCircleId(cirId));
    }
}
