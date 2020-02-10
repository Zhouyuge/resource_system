package com.bishe.main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Circle {
    private Integer id;

    private String circleName;

    private Integer circleUserNum;

    private String circlePic;

    private Integer circleType;

    private String circleLabel;

    private String circleInstruction;

    private String circleUserId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName == null ? null : circleName.trim();
    }

    public Integer getCircleUserNum() {
        return circleUserNum;
    }

    public void setCircleUserNum(Integer circleUserNum) {
        this.circleUserNum = circleUserNum;
    }

    public String getCirclePic() {
        return circlePic;
    }

    public void setCirclePic(String circlePic) {
        this.circlePic = circlePic == null ? null : circlePic.trim();
    }

    public Integer getCircleType() {
        return circleType;
    }

    public void setCircleType(Integer circleType) {
        this.circleType = circleType;
    }

    public String getCircleLabel() {
        return circleLabel;
    }

    public void setCircleLabel(String circleLabel) {
        this.circleLabel = circleLabel == null ? null : circleLabel.trim();
    }

    public String getCircleInstruction() {
        return circleInstruction;
    }

    public void setCircleInstruction(String circleInstruction) {
        this.circleInstruction = circleInstruction == null ? null : circleInstruction.trim();
    }

    public String getCircleUserId() {
        return circleUserId;
    }

    public void setCircleUserId(String circleUserId) {
        this.circleUserId = circleUserId == null ? null : circleUserId.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}