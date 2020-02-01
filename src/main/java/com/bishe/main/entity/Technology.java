package com.bishe.main.entity;

import java.util.Date;

public class Technology {
    private Integer id;

    private String technologyName;

    private Integer technologyNum;

    private String technologyIntroduction;

    private Date createTime;

    private Date editTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName == null ? null : technologyName.trim();
    }

    public Integer getTechnologyNum() {
        return technologyNum;
    }

    public void setTechnologyNum(Integer technologyNum) {
        this.technologyNum = technologyNum;
    }

    public String getTechnologyIntroduction() {
        return technologyIntroduction;
    }

    public void setTechnologyIntroduction(String technologyIntroduction) {
        this.technologyIntroduction = technologyIntroduction == null ? null : technologyIntroduction.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }
}