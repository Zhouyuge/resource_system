package com.bishe.main.controller;

import com.bishe.main.entity.Comment;
import com.bishe.main.entity.result.Result;
import com.bishe.main.service.CommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/29 13:41
 */
@RestController
@RequestMapping("/comment/api")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ApiOperation("分功能获取评论树")
    @GetMapping("/comments_func/{function_id}/{comment_id}")
    public Result<List> getCommentsByFunctionId(@PathVariable("function_id")Integer functionId, @PathVariable("comment_id")Integer commentId ) {
        List<Comment> comments = commentService.getCommentListByFunctionId(functionId, commentId);
        Result<List> result = Result.success(comments);
        return result;
    }

    @ApiOperation("添加评论")
    @PostMapping("/comment")
    public Result addComment(@RequestBody Comment comment){
        return Result.success(commentService.addComment(comment));
    }
}
