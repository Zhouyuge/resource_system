package com.bishe.main.entity;

public class ProblemWithBLOBs extends Problem {
    private String problemContent;

    private String allRightPeopleIds;

    public String getProblemContent() {
        return problemContent;
    }

    public void setProblemContent(String problemContent) {
        this.problemContent = problemContent == null ? null : problemContent.trim();
    }

    public String getAllRightPeopleIds() {
        return allRightPeopleIds;
    }

    public void setAllRightPeopleIds(String allRightPeopleIds) {
        this.allRightPeopleIds = allRightPeopleIds == null ? null : allRightPeopleIds.trim();
    }
}