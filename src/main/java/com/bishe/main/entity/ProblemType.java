package com.bishe.main.entity;

public class ProblemType {
    private Integer problemTypeId;

    private String problemTypeName;

    private String problemTypeDescription;

    private String problemTypeImg;

    public Integer getProblemTypeId() {
        return problemTypeId;
    }

    public void setProblemTypeId(Integer problemTypeId) {
        this.problemTypeId = problemTypeId;
    }

    public String getProblemTypeName() {
        return problemTypeName;
    }

    public void setProblemTypeName(String problemTypeName) {
        this.problemTypeName = problemTypeName == null ? null : problemTypeName.trim();
    }

    public String getProblemTypeDescription() {
        return problemTypeDescription;
    }

    public void setProblemTypeDescription(String problemTypeDescription) {
        this.problemTypeDescription = problemTypeDescription == null ? null : problemTypeDescription.trim();
    }

    public String getProblemTypeImg() {
        return problemTypeImg;
    }

    public void setProblemTypeImg(String problemTypeImg) {
        this.problemTypeImg = problemTypeImg == null ? null : problemTypeImg.trim();
    }
}