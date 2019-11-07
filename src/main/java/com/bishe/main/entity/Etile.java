package com.bishe.main.entity;

public class Etile {
    private Integer etileId;

    private String etileName;

    private String etilePoint;

    private String etileType;

    private Integer etileNo;

    public Integer getEtileId() {
        return etileId;
    }

    public void setEtileId(Integer etileId) {
        this.etileId = etileId;
    }

    public String getEtileName() {
        return etileName;
    }

    public void setEtileName(String etileName) {
        this.etileName = etileName == null ? null : etileName.trim();
    }

    public String getEtilePoint() {
        return etilePoint;
    }

    public void setEtilePoint(String etilePoint) {
        this.etilePoint = etilePoint == null ? null : etilePoint.trim();
    }

    public String getEtileType() {
        return etileType;
    }

    public void setEtileType(String etileType) {
        this.etileType = etileType == null ? null : etileType.trim();
    }

    public Integer getEtileNo() {
        return etileNo;
    }

    public void setEtileNo(Integer etileNo) {
        this.etileNo = etileNo;
    }
}