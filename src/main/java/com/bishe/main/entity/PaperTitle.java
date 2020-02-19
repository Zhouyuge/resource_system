package com.bishe.main.entity;

public class PaperTitle {
    private Integer id;

    private Integer paperId;

    private String paperTitleName;

    private Integer paperTitleType;

    private String paperTitleBody;

    private Integer paperTitleHard;

    private Integer paperTitleAnserNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperTitleName() {
        return paperTitleName;
    }

    public void setPaperTitleName(String paperTitleName) {
        this.paperTitleName = paperTitleName == null ? null : paperTitleName.trim();
    }

    public Integer getPaperTitleType() {
        return paperTitleType;
    }

    public void setPaperTitleType(Integer paperTitleType) {
        this.paperTitleType = paperTitleType;
    }

    public String getPaperTitleBody() {
        return paperTitleBody;
    }

    public void setPaperTitleBody(String paperTitleBody) {
        this.paperTitleBody = paperTitleBody == null ? null : paperTitleBody.trim();
    }

    public Integer getPaperTitleHard() {
        return paperTitleHard;
    }

    public void setPaperTitleHard(Integer paperTitleHard) {
        this.paperTitleHard = paperTitleHard;
    }

    public Integer getPaperTitleAnserNum() {
        return paperTitleAnserNum;
    }

    public void setPaperTitleAnserNum(Integer paperTitleAnserNum) {
        this.paperTitleAnserNum = paperTitleAnserNum;
    }
}