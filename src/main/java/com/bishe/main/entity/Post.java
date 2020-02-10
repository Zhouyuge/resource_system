package com.bishe.main.entity;

import java.util.Date;

public class Post {
    private Integer id;

    private Integer factoryId;

    private String postName;

    private Integer postType;

    private String postCity;

    private String postInfo;

    private String postRequirement;

    private String postWelfare;

    private Date publishTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public Integer getPostType() {
        return postType;
    }

    public void setPostType(Integer postType) {
        this.postType = postType;
    }

    public String getPostCity() {
        return postCity;
    }

    public void setPostCity(String postCity) {
        this.postCity = postCity == null ? null : postCity.trim();
    }

    public String getPostInfo() {
        return postInfo;
    }

    public void setPostInfo(String postInfo) {
        this.postInfo = postInfo == null ? null : postInfo.trim();
    }

    public String getPostRequirement() {
        return postRequirement;
    }

    public void setPostRequirement(String postRequirement) {
        this.postRequirement = postRequirement == null ? null : postRequirement.trim();
    }

    public String getPostWelfare() {
        return postWelfare;
    }

    public void setPostWelfare(String postWelfare) {
        this.postWelfare = postWelfare == null ? null : postWelfare.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}