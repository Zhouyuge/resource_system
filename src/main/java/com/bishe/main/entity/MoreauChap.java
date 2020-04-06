package com.bishe.main.entity;

public class MoreauChap {
    private Integer id;

    private String chapName;

    private Integer moreauId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChapName() {
        return chapName;
    }

    public void setChapName(String chapName) {
        this.chapName = chapName == null ? null : chapName.trim();
    }

    public Integer getMoreauId() {
        return moreauId;
    }

    public void setMoreauId(Integer moreauId) {
        this.moreauId = moreauId;
    }
}