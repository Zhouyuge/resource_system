package com.bishe.main.service.impl;

import com.bishe.main.dao.CommentMapper;
import com.bishe.main.dao.UserMapper;
import com.bishe.main.entity.Comment;
import com.bishe.main.entity.CommentExample;
import com.bishe.main.entity.User;
import com.bishe.main.entity.UserExample;
import com.bishe.main.service.CommentService;
import com.bishe.main.util.NodeUtil;
import com.bishe.main.util.PrettyTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kirito
 * @Date 2020/2/8 19:42
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Comment> getCommentListByType(Integer functionId, Integer objectId) {
        CommentExample commentExample = new CommentExample();
        commentExample.or().andFunctionTypeEqualTo(functionId).andObjectIdEqualTo(objectId);
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        return comments;
    }


    /**
     * 根据功能点获取评论
     * @param functionId
     * @return
     */
    @Override
    public List<Comment> getCommentListByFunctionId(Integer functionId, Integer commentId) {
        CommentExample commentExample = new CommentExample();
        commentExample.or().andFunctionTypeEqualTo(functionId).andObjectIdEqualTo(commentId);
        commentExample.setOrderByClause("comment_time");
        List<Comment> commentList = commentMapper.selectByExample(commentExample);
        commentList = NodeUtil.getConvertNodes(commentList);
        commentList = commentList.stream().map(e -> {
           e = getUserForComment(e);
           return e;
        }).collect(Collectors.toList());
        return commentList;
    }

    /**
     * 递归为评论设置属性
     * @param comment
     * @return
     */
    public Comment getUserForComment(Comment comment) {
        comment.setPrettyTime(PrettyTimeUtil.getPrettyTime(comment.getCommentTime()).replaceAll(" ", ""));
        User user = userMapper.selectByPrimaryKey(comment.getUserId());
        comment.setUser(user);
        // 设置父节点用户名
        if (comment.getParentId() != 0) {
           Comment comment1 = commentMapper.selectByPrimaryKey(comment.getParentId());
           User pUser = userMapper.selectByPrimaryKey(comment1.getUserId());
           comment.setParentName(pUser.getUserVisualName());
        }

        if(comment.isLeaf()){
            return comment;
        }

        for(int i = 0; i < comment.getChildren().size(); i++) {
            getUserForComment(comment.getChildren().get(i));
        }

        return comment;
    }

    @Override
    public List<Comment> getCommentListByParentId(Integer parentId) {
        return null;
    }

    @Override
    public Comment getCommentById(Integer commentId) {
        return null;
    }

    /**
     * 插入评价
     * @param comment
     * @return
     */
    @Override
    public int addComment(Comment comment) {
        comment.setCommentTime(new Date());
        if (comment.getParentId() != 0) {
            // 更新父亲节点评论数目
            Comment parent = commentMapper.selectByPrimaryKey(comment.getParentId());
            parent.setCommentNum(parent.getCommentNum() + 1);
            commentMapper.updateByPrimaryKeySelective(parent);
        }
        return commentMapper.insertSelective(comment);
    }

    @Override
    public int updateComment(Comment comment) {
        return 0;
    }

    @Override
    public int deteleCommentCondition(Integer conditionId) {
        return 0;
    }
}
