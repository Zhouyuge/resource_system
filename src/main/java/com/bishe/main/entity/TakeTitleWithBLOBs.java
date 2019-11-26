package com.bishe.main.entity;

public class TakeTitleWithBLOBs extends TakeTitle {
    private String rightTitleId;

    private String wrongTitleId;

    public String getRightTitleId() {
        return rightTitleId;
    }

    public void setRightTitleId(String rightTitleId) {
        this.rightTitleId = rightTitleId == null ? null : rightTitleId.trim();
    }

    public String getWrongTitleId() {
        return wrongTitleId;
    }

    public void setWrongTitleId(String wrongTitleId) {
        this.wrongTitleId = wrongTitleId == null ? null : wrongTitleId.trim();
    }
}