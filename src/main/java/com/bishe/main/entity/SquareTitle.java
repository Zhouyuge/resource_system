package com.bishe.main.entity;

import java.util.Date;

public class SquareTitle {
    private Integer id;

    private String titleName;

    private String titleContent;

    private String titleLabels;

    private Integer titleHard;

    private String userId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    public String getTitleContent() {
        return titleContent;
    }

    public void setTitleContent(String titleContent) {
        this.titleContent = titleContent == null ? null : titleContent.trim();
    }

    public String getTitleLabels() {
        return titleLabels;
    }

    public void setTitleLabels(String titleLabels) {
        this.titleLabels = titleLabels == null ? null : titleLabels.trim();
    }

    public Integer getTitleHard() {
        return titleHard;
    }

    public void setTitleHard(Integer titleHard) {
        this.titleHard = titleHard;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}