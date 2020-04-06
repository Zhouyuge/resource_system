package com.bishe.main.entity;

import java.util.Date;

public class Moreau {
    private Integer id;

    private String moreauName;

    private String moreauDetail;

    private Date createTime;

    private Date editTime;

    private String moreauImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoreauName() {
        return moreauName;
    }

    public void setMoreauName(String moreauName) {
        this.moreauName = moreauName == null ? null : moreauName.trim();
    }

    public String getMoreauDetail() {
        return moreauDetail;
    }

    public void setMoreauDetail(String moreauDetail) {
        this.moreauDetail = moreauDetail == null ? null : moreauDetail.trim();
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

    public String getMoreauImg() {
        return moreauImg;
    }

    public void setMoreauImg(String moreauImg) {
        this.moreauImg = moreauImg == null ? null : moreauImg.trim();
    }
}