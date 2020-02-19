package com.bishe.main.entity;

public class Paper {
    private Integer id;

    private Integer uniId;

    private String paperYear;

    private String paperCode;

    private String paperHot;

    private Integer titleNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUniId() {
        return uniId;
    }

    public void setUniId(Integer uniId) {
        this.uniId = uniId;
    }

    public String getPaperYear() {
        return paperYear;
    }

    public void setPaperYear(String paperYear) {
        this.paperYear = paperYear == null ? null : paperYear.trim();
    }

    public String getPaperCode() {
        return paperCode;
    }

    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode == null ? null : paperCode.trim();
    }

    public String getPaperHot() {
        return paperHot;
    }

    public void setPaperHot(String paperHot) {
        this.paperHot = paperHot == null ? null : paperHot.trim();
    }

    public Integer getTitleNum() {
        return titleNum;
    }

    public void setTitleNum(Integer titleNum) {
        this.titleNum = titleNum;
    }
}