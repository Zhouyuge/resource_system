package com.bishe.main.entity;

import java.util.Date;

public class TakeTitle {
    private Integer takeId;

    private String userId;

    private Date takeEditTime;

    public Integer getTakeId() {
        return takeId;
    }

    public void setTakeId(Integer takeId) {
        this.takeId = takeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getTakeEditTime() {
        return takeEditTime;
    }

    public void setTakeEditTime(Date takeEditTime) {
        this.takeEditTime = takeEditTime;
    }
}