package com.bishe.main.service.impl;

import com.bishe.main.dao.CommentMapper;
import com.bishe.main.entity.Comment;
import com.bishe.main.entity.CommentExample;
import com.bishe.main.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/8 19:42
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentListByType(Integer functionId, Integer objectId) {
        CommentExample commentExample = new CommentExample();
        commentExample.or().andFunctionTypeEqualTo(functionId).andObjectIdEqualTo(objectId);
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        return comments;
    }

    @Override
    public List<Comment> getCommentListByParentId(Integer parentId) {
        return null;
    }

    @Override
    public Comment getCommentById(Integer commentId) {
        return null;
    }

    @Override
    public int addComment(Comment comment) {
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
