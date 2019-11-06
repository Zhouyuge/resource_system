package com.bishe.main.entity;

import java.util.Date;

public class EtileCategory {
    private Integer etileCategoryId;

    private String etileCategoryName;

    private Integer etileCategoryNum;

    private String etileCategoryPhoto;

    private Date etileCategoryCreateTime;

    private Date etileCategoryEditTime;

    public Integer getEtileCategoryId() {
        return etileCategoryId;
    }

    public void setEtileCategoryId(Integer etileCategoryId) {
        this.etileCategoryId = etileCategoryId;
    }

    public String getEtileCategoryName() {
        return etileCategoryName;
    }

    public void setEtileCategoryName(String etileCategoryName) {
        this.etileCategoryName = etileCategoryName == null ? null : etileCategoryName.trim();
    }

    public Integer getEtileCategoryNum() {
        return etileCategoryNum;
    }

    public void setEtileCategoryNum(Integer etileCategoryNum) {
        this.etileCategoryNum = etileCategoryNum;
    }

    public String getEtileCategoryPhoto() {
        return etileCategoryPhoto;
    }

    public void setEtileCategoryPhoto(String etileCategoryPhoto) {
        this.etileCategoryPhoto = etileCategoryPhoto == null ? null : etileCategoryPhoto.trim();
    }

    public Date getEtileCategoryCreateTime() {
        return etileCategoryCreateTime;
    }

    public void setEtileCategoryCreateTime(Date etileCategoryCreateTime) {
        this.etileCategoryCreateTime = etileCategoryCreateTime;
    }

    public Date getEtileCategoryEditTime() {
        return etileCategoryEditTime;
    }

    public void setEtileCategoryEditTime(Date etileCategoryEditTime) {
        this.etileCategoryEditTime = etileCategoryEditTime;
    }
}