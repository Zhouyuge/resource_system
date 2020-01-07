package com.bishe.main.entity;

import java.util.Date;

public class RestBlog {
    private String blogId;

    private String blogName;

    private String blogNote;

    private Boolean blogTop;

    private Date blogCreateTime;

    private Date blogUpdateTime;

    private String blogCategoryId;

    private String userId;

    private Integer viewNum;

    private Integer agreeNum;

    private String blogPicture;

    private String blogContent;

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId == null ? null : blogId.trim();
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName == null ? null : blogName.trim();
    }

    public String getBlogNote() {
        return blogNote;
    }

    public void setBlogNote(String blogNote) {
        this.blogNote = blogNote == null ? null : blogNote.trim();
    }

    public Boolean getBlogTop() {
        return blogTop;
    }

    public void setBlogTop(Boolean blogTop) {
        this.blogTop = blogTop;
    }

    public Date getBlogCreateTime() {
        return blogCreateTime;
    }

    public void setBlogCreateTime(Date blogCreateTime) {
        this.blogCreateTime = blogCreateTime;
    }

    public Date getBlogUpdateTime() {
        return blogUpdateTime;
    }

    public void setBlogUpdateTime(Date blogUpdateTime) {
        this.blogUpdateTime = blogUpdateTime;
    }

    public String getBlogCategoryId() {
        return blogCategoryId;
    }

    public void setBlogCategoryId(String blogCategoryId) {
        this.blogCategoryId = blogCategoryId == null ? null : blogCategoryId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public Integer getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(Integer agreeNum) {
        this.agreeNum = agreeNum;
    }

    public String getBlogPicture() {
        return blogPicture;
    }

    public void setBlogPicture(String blogPicture) {
        this.blogPicture = blogPicture == null ? null : blogPicture.trim();
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }
}