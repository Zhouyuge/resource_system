package com.bishe.main.entity;

import java.util.Date;

public class SubmitRecord {
    private Long submitId;

    private Date submitTime;

    private Long submitProblemId;

    private String submitUserId;

    private Double score;

    private Boolean isAccepted;

    private String codeLanguage;

    private String codeFilePath;

    private String submitRecordTableName;

    private String details;

    public Long getSubmitId() {
        return submitId;
    }

    public void setSubmitId(Long submitId) {
        this.submitId = submitId;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Long getSubmitProblemId() {
        return submitProblemId;
    }

    public void setSubmitProblemId(Long submitProblemId) {
        this.submitProblemId = submitProblemId;
    }

    public String getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserId(String submitUserId) {
        this.submitUserId = submitUserId == null ? null : submitUserId.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(Boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public String getCodeLanguage() {
        return codeLanguage;
    }

    public void setCodeLanguage(String codeLanguage) {
        this.codeLanguage = codeLanguage == null ? null : codeLanguage.trim();
    }

    public String getCodeFilePath() {
        return codeFilePath;
    }

    public void setCodeFilePath(String codeFilePath) {
        this.codeFilePath = codeFilePath == null ? null : codeFilePath.trim();
    }

    public String getSubmitRecordTableName() {
        return submitRecordTableName;
    }

    public void setSubmitRecordTableName(String submitRecordTableName) {
        this.submitRecordTableName = submitRecordTableName == null ? null : submitRecordTableName.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }
}