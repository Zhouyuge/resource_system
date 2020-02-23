package com.bishe.main.entity;

public class ProjectAction {
    private Integer id;

    private String actionName;

    private String actionType;

    private Integer actionHard;

    private String actionImg;

    private String actionDetail;

    private String actionProposeTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName == null ? null : actionName.trim();
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType == null ? null : actionType.trim();
    }

    public Integer getActionHard() {
        return actionHard;
    }

    public void setActionHard(Integer actionHard) {
        this.actionHard = actionHard;
    }

    public String getActionImg() {
        return actionImg;
    }

    public void setActionImg(String actionImg) {
        this.actionImg = actionImg == null ? null : actionImg.trim();
    }

    public String getActionDetail() {
        return actionDetail;
    }

    public void setActionDetail(String actionDetail) {
        this.actionDetail = actionDetail == null ? null : actionDetail.trim();
    }

    public String getActionProposeTime() {
        return actionProposeTime;
    }

    public void setActionProposeTime(String actionProposeTime) {
        this.actionProposeTime = actionProposeTime == null ? null : actionProposeTime.trim();
    }
}