package com.bishe.main.entity;

public class OjRecordWithBLOBs extends OjRecord {
    private String rightProblemId;

    private String doProblemId;

    public String getRightProblemId() {
        return rightProblemId;
    }

    public void setRightProblemId(String rightProblemId) {
        this.rightProblemId = rightProblemId == null ? null : rightProblemId.trim();
    }

    public String getDoProblemId() {
        return doProblemId;
    }

    public void setDoProblemId(String doProblemId) {
        this.doProblemId = doProblemId == null ? null : doProblemId.trim();
    }
}