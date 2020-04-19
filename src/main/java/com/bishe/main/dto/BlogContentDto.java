package com.bishe.main.dto;

import com.bishe.main.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @author Kirito
 * @Date 2019/11/12 11:38
 */
public class BlogContentDto {
    private Integer blogCenterId;

    private String blogCenterName;

    private String blogCenterAuthor;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date blogCenterEditTime;

    private Integer blogCenterAgree;

    private Integer blogCenterCollect;

    private String blogCenterContent;

    private String blogCenterPic;

    private User user;

    private String prettyTime;

    public Integer getBlogCenterId() {
        return blogCenterId;
    }

    public void setBlogCenterId(Integer blogCenterId) {
        this.blogCenterId = blogCenterId;
    }

    public String getBlogCenterName() {
        return blogCenterName;
    }

    public void setBlogCenterName(String blogCenterName) {
        this.blogCenterName = blogCenterName;
    }

    public String getBlogCenterAuthor() {
        return blogCenterAuthor;
    }

    public void setBlogCenterAuthor(String blogCenterAuthor) {
        this.blogCenterAuthor = blogCenterAuthor;
    }

    public Date getBlogCenterEditTime() {
        return blogCenterEditTime;
    }

    public void setBlogCenterEditTime(Date blogCenterEditTime) {
        this.blogCenterEditTime = blogCenterEditTime;
    }

    public Integer getBlogCenterAgree() {
        return blogCenterAgree;
    }

    public void setBlogCenterAgree(Integer blogCenterAgree) {
        this.blogCenterAgree = blogCenterAgree;
    }

    public Integer getBlogCenterCollect() {
        return blogCenterCollect;
    }

    public void setBlogCenterCollect(Integer blogCenterCollect) {
        this.blogCenterCollect = blogCenterCollect;
    }

    public String getBlogCenterContent() {
        return blogCenterContent;
    }

    public void setBlogCenterContent(String blogCenterContent) {
        this.blogCenterContent = blogCenterContent;
    }

    public String getBlogCenterPic() {
        return blogCenterPic;
    }

    public void setBlogCenterPic(String blogCenterPic) {
        this.blogCenterPic = blogCenterPic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPrettyTime() {
        return prettyTime;
    }

    public void setPrettyTime(String prettyTime) {
        this.prettyTime = prettyTime;
    }
}
