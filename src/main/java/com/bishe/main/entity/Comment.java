package com.bishe.main.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {
    // 自身id
    private Integer id;
    //  父节点id
    private Integer parentId;

    private String userId;

    private Integer commentType;

    private Integer functionType;

    private String commentContent;

    private Date commentTime;

    private Integer agreeNum;

    private Integer commentNum;

    private Integer objectId;

    private User user;

    private String prettyTime;

    private String parentName;

    private List<Comment> children = new ArrayList<>();

    public Comment(Integer id, Integer parentId, Integer functionType, Integer objectId) {
        this.id = id;
        this.parentId = parentId;
        this.functionType = functionType;
        this.objectId = objectId;
    }

    public Comment() {

    }

    public User getUser() {
        return user;
    }

    public String getPrettyTime() {
        return prettyTime;
    }

    public void setPrettyTime(String prettyTime) {
        this.prettyTime = prettyTime;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getChildren() {
        return children;
    }

    public void setChildren(List<Comment> children) {
        this.children = children ;
    }

    public boolean isRoot() {
        // 判断是否为根
        return this.parentId == 0;
    }

    public boolean isLeaf() {
        // 判断是否为叶子节点
        return this.children.size() == 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    public Integer getFunctionType() {
        return functionType;
    }

    public void setFunctionType(Integer functionType) {
        this.functionType = functionType;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(Integer agreeNum) {
        this.agreeNum = agreeNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }
}