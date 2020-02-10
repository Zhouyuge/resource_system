package com.bishe.main.service;

import com.bishe.main.entity.Comment;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/8 19:36
 */
public interface CommentService {
    List<Comment> getCommentListByType(Integer functionId, Integer objectId);

    List<Comment> getCommentListByParentId(Integer parentId);

    Comment getCommentById(Integer commentId);

    int addComment(Comment comment);

    int updateComment(Comment comment);

    int deteleCommentCondition(Integer conditionId);
}
