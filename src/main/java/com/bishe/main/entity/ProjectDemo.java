package com.bishe.main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProjectDemo {
    private Integer id;

    private String demoInfo;

    private String userId;

    private String demoUrl;

    private String demoDownUrl;

    private Integer demoStatus;

    private Integer projectId;

    private Date uploadTime;

    private String demoName;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDemoInfo() {
        return demoInfo;
    }

    public void setDemoInfo(String demoInfo) {
        this.demoInfo = demoInfo == null ? null : demoInfo.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDemoUrl() {
        return demoUrl;
    }

    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl == null ? null : demoUrl.trim();
    }

    public String getDemoDownUrl() {
        return demoDownUrl;
    }

    public void setDemoDownUrl(String demoDownUrl) {
        this.demoDownUrl = demoDownUrl == null ? null : demoDownUrl.trim();
    }

    public Integer getDemoStatus() {
        return demoStatus;
    }

    public void setDemoStatus(Integer demoStatus) {
        this.demoStatus = demoStatus;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS", timezone = "GMT+8")
    public Date getUploadTime() {
        return uploadTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS", timezone = "GMT+8")
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName == null ? null : demoName.trim();
    }
}