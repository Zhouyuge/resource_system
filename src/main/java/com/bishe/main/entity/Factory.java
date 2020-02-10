package com.bishe.main.entity;

import java.util.Date;

public class Factory {
    private Integer id;

    private String factoryName;

    private String factoryInfo;

    private String factoryPlace;

    private String factoryImg;

    private String beListed;

    private Date addTime;

    private String cityList;

    private String postList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getFactoryInfo() {
        return factoryInfo;
    }

    public void setFactoryInfo(String factoryInfo) {
        this.factoryInfo = factoryInfo == null ? null : factoryInfo.trim();
    }

    public String getFactoryPlace() {
        return factoryPlace;
    }

    public void setFactoryPlace(String factoryPlace) {
        this.factoryPlace = factoryPlace == null ? null : factoryPlace.trim();
    }

    public String getFactoryImg() {
        return factoryImg;
    }

    public void setFactoryImg(String factoryImg) {
        this.factoryImg = factoryImg == null ? null : factoryImg.trim();
    }

    public String getBeListed() {
        return beListed;
    }

    public void setBeListed(String beListed) {
        this.beListed = beListed == null ? null : beListed.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getCityList() {
        return cityList;
    }

    public void setCityList(String cityList) {
        this.cityList = cityList == null ? null : cityList.trim();
    }

    public String getPostList() {
        return postList;
    }

    public void setPostList(String postList) {
        this.postList = postList == null ? null : postList.trim();
    }
}