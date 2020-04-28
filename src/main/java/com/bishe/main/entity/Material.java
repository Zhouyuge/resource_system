package com.bishe.main.entity;

import java.util.Date;

public class Material {
    private Integer id;

    private String materialName;

    private Integer categoryId;

    private String materialSpeci;

    private String materialPacking;

    private String materialContent;

    private String materialInfo;

    private String materialImg;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getMaterialSpeci() {
        return materialSpeci;
    }

    public void setMaterialSpeci(String materialSpeci) {
        this.materialSpeci = materialSpeci == null ? null : materialSpeci.trim();
    }

    public String getMaterialPacking() {
        return materialPacking;
    }

    public void setMaterialPacking(String materialPacking) {
        this.materialPacking = materialPacking == null ? null : materialPacking.trim();
    }

    public String getMaterialContent() {
        return materialContent;
    }

    public void setMaterialContent(String materialContent) {
        this.materialContent = materialContent == null ? null : materialContent.trim();
    }

    public String getMaterialInfo() {
        return materialInfo;
    }

    public void setMaterialInfo(String materialInfo) {
        this.materialInfo = materialInfo == null ? null : materialInfo.trim();
    }

    public String getMaterialImg() {
        return materialImg;
    }

    public void setMaterialImg(String materialImg) {
        this.materialImg = materialImg == null ? null : materialImg.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}