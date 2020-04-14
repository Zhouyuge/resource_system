package com.bishe.main.entity;

public class Problem {
    private Long problemId;

    private Integer problemTypeId;

    private String problemName;

    private String inputFileRootPath;

    private String outputFileRootPath;

    private String problemLabel;

    private Integer timeLimit;

    private Integer memoryLimit;

    private Integer problemCreatorId;

    private Integer problemDifficulty;

    private Integer problemValue;

    private Integer problemVersion;

    private Boolean isPublish;

    private Integer totalSubmitCount;

    private Integer totalRightCount;

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    public Integer getProblemTypeId() {
        return problemTypeId;
    }

    public void setProblemTypeId(Integer problemTypeId) {
        this.problemTypeId = problemTypeId;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName == null ? null : problemName.trim();
    }

    public String getInputFileRootPath() {
        return inputFileRootPath;
    }

    public void setInputFileRootPath(String inputFileRootPath) {
        this.inputFileRootPath = inputFileRootPath == null ? null : inputFileRootPath.trim();
    }

    public String getOutputFileRootPath() {
        return outputFileRootPath;
    }

    public void setOutputFileRootPath(String outputFileRootPath) {
        this.outputFileRootPath = outputFileRootPath == null ? null : outputFileRootPath.trim();
    }

    public String getProblemLabel() {
        return problemLabel;
    }

    public void setProblemLabel(String problemLabel) {
        this.problemLabel = problemLabel == null ? null : problemLabel.trim();
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(Integer memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public Integer getProblemCreatorId() {
        return problemCreatorId;
    }

    public void setProblemCreatorId(Integer problemCreatorId) {
        this.problemCreatorId = problemCreatorId;
    }

    public Integer getProblemDifficulty() {
        return problemDifficulty;
    }

    public void setProblemDifficulty(Integer problemDifficulty) {
        this.problemDifficulty = problemDifficulty;
    }

    public Integer getProblemValue() {
        return problemValue;
    }

    public void setProblemValue(Integer problemValue) {
        this.problemValue = problemValue;
    }

    public Integer getProblemVersion() {
        return problemVersion;
    }

    public void setProblemVersion(Integer problemVersion) {
        this.problemVersion = problemVersion;
    }

    public Boolean getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Boolean isPublish) {
        this.isPublish = isPublish;
    }

    public Integer getTotalSubmitCount() {
        return totalSubmitCount;
    }

    public void setTotalSubmitCount(Integer totalSubmitCount) {
        this.totalSubmitCount = totalSubmitCount;
    }

    public Integer getTotalRightCount() {
        return totalRightCount;
    }

    public void setTotalRightCount(Integer totalRightCount) {
        this.totalRightCount = totalRightCount;
    }
}