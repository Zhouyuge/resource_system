package com.bishe.main.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Kirito
 * @Date 2019/8/2 12:57
 */
public class BlogRestDto implements Serializable {

    private static final long serialVersionUID = 49265683788577546L;

    private String blogId;

    private String blogName;

    private String blogNote;

    private Boolean blogTop;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Date blogCreateTime;

    private String blogCategoryId;

    private Integer viewNum;

    private Integer agreeNum;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogNote() {
        return blogNote;
    }

    public void setBlogNote(String blogNote) {
        this.blogNote = blogNote;
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

    public String getBlogCategoryId() {
        return blogCategoryId;
    }

    public void setBlogCategoryId(String blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
    }

    @Override
    public String toString() {
        return "BlogDto{" +
                "blogId='" + blogId + '\'' +
                ", blogName='" + blogName + '\'' +
                ", blogNote='" + blogNote + '\'' +
                ", blogTop=" + blogTop +
                ", blogCreateTime=" + blogCreateTime +
                ", blogCategoryId='" + blogCategoryId + '\'' +
                '}';
    }
}
