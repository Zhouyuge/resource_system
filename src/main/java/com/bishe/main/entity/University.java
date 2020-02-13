package com.bishe.main.entity;

public class University {
    private Integer id;

    private String univerName;

    private Integer cityId;

    private Integer titleNum;

    private String univerImg;

    private String univerUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniverName() {
        return univerName;
    }

    public void setUniverName(String univerName) {
        this.univerName = univerName == null ? null : univerName.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getTitleNum() {
        return titleNum;
    }

    public void setTitleNum(Integer titleNum) {
        this.titleNum = titleNum;
    }

    public String getUniverImg() {
        return univerImg;
    }

    public void setUniverImg(String univerImg) {
        this.univerImg = univerImg == null ? null : univerImg.trim();
    }

    public String getUniverUrl() {
        return univerUrl;
    }

    public void setUniverUrl(String univerUrl) {
        this.univerUrl = univerUrl == null ? null : univerUrl.trim();
    }
}