package com.bishe.main.entity;

import java.util.Date;

public class BlogCenter {
    private Integer blogCenterId;

    private String blogCenterName;

    private String blogCenterAuthor;

    private String blogCenterPic;

    private Integer blogCenterAgree;

    private Integer blogCenterCollect;

    private Date blogCenterEditTime;

    private String blogCenterVlog;

    private String blogCenterContent;

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
        this.blogCenterName = blogCenterName == null ? null : blogCenterName.trim();
    }

    public String getBlogCenterAuthor() {
        return blogCenterAuthor;
    }

    public void setBlogCenterAuthor(String blogCenterAuthor) {
        this.blogCenterAuthor = blogCenterAuthor == null ? null : blogCenterAuthor.trim();
    }

    public String getBlogCenterPic() {
        return blogCenterPic;
    }

    public void setBlogCenterPic(String blogCenterPic) {
        this.blogCenterPic = blogCenterPic == null ? null : blogCenterPic.trim();
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

    public Date getBlogCenterEditTime() {
        return blogCenterEditTime;
    }

    public void setBlogCenterEditTime(Date blogCenterEditTime) {
        this.blogCenterEditTime = blogCenterEditTime;
    }

    public String getBlogCenterVlog() {
        return blogCenterVlog;
    }

    public void setBlogCenterVlog(String blogCenterVlog) {
        this.blogCenterVlog = blogCenterVlog == null ? null : blogCenterVlog.trim();
    }

    public String getBlogCenterContent() {
        return blogCenterContent;
    }

    public void setBlogCenterContent(String blogCenterContent) {
        this.blogCenterContent = blogCenterContent == null ? null : blogCenterContent.trim();
    }
}