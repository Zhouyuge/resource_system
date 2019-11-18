package com.bishe.main.entity;

import java.util.Date;

public class SelectTitle {
    private Integer titleId;

    private String titleName;

    private String titleContent;

    private String titleAnswer;

    private Integer titleHard;

    private String titleAuthor;

    private Integer titleType;

    private Integer titleRight;

    private Integer titleCount;

    private Date titleCreateTime;

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    public String getTitleContent() {
        return titleContent;
    }

    public void setTitleContent(String titleContent) {
        this.titleContent = titleContent == null ? null : titleContent.trim();
    }

    public String getTitleAnswer() {
        return titleAnswer;
    }

    public void setTitleAnswer(String titleAnswer) {
        this.titleAnswer = titleAnswer == null ? null : titleAnswer.trim();
    }

    public Integer getTitleHard() {
        return titleHard;
    }

    public void setTitleHard(Integer titleHard) {
        this.titleHard = titleHard;
    }

    public String getTitleAuthor() {
        return titleAuthor;
    }

    public void setTitleAuthor(String titleAuthor) {
        this.titleAuthor = titleAuthor == null ? null : titleAuthor.trim();
    }

    public Integer getTitleType() {
        return titleType;
    }

    public void setTitleType(Integer titleType) {
        this.titleType = titleType;
    }

    public Integer getTitleRight() {
        return titleRight;
    }

    public void setTitleRight(Integer titleRight) {
        this.titleRight = titleRight;
    }

    public Integer getTitleCount() {
        return titleCount;
    }

    public void setTitleCount(Integer titleCount) {
        this.titleCount = titleCount;
    }

    public Date getTitleCreateTime() {
        return titleCreateTime;
    }

    public void setTitleCreateTime(Date titleCreateTime) {
        this.titleCreateTime = titleCreateTime;
    }
}