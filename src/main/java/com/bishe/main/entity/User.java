package com.bishe.main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {
    private String userId;

    private String userName;

    private String userPassword;

    private Boolean userSex;

    private String userVisualName;

    private String userTel;

    private String userEmal;

    private String userDetail;

    private String userHeadPic;

    private Date userCreateTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Boolean getUserSex() {
        return userSex;
    }

    public void setUserSex(Boolean userSex) {
        this.userSex = userSex;
    }

    public String getUserVisualName() {
        return userVisualName;
    }

    public void setUserVisualName(String userVisualName) {
        this.userVisualName = userVisualName == null ? null : userVisualName.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getUserEmal() {
        return userEmal;
    }

    public void setUserEmal(String userEmal) {
        this.userEmal = userEmal == null ? null : userEmal.trim();
    }

    public String getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(String userDetail) {
        this.userDetail = userDetail == null ? null : userDetail.trim();
    }

    public String getUserHeadPic() {
        return userHeadPic;
    }

    public void setUserHeadPic(String userHeadPic) {
        this.userHeadPic = userHeadPic == null ? null : userHeadPic.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getUserCreateTime() {
        return userCreateTime;
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex=" + userSex +
                ", userVisualName='" + userVisualName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userEmal='" + userEmal + '\'' +
                ", userDetail='" + userDetail + '\'' +
                ", userHeadPic='" + userHeadPic + '\'' +
                ", userCreateTime=" + userCreateTime +
                '}';
    }
}