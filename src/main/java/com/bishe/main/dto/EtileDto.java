package com.bishe.main.dto;

/**
 * @author Kirito
 * @Date 2019/11/7 12:00
 */
public class EtileDto {
    private Integer etileId;    //id

    private String etileName;   //标题

    private String etilePoint;  //要点

    private String etileType;   //类型

    private Integer etileNo;    //分类Id

    private String etitleQuestion;  //问题

    private String etitleAnswer;    //答案

    private Integer etileNoAli;     //题目别名

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
        this.etileName = etileName;
    }

    public String getEtilePoint() {
        return etilePoint;
    }

    public void setEtilePoint(String etilePoint) {
        this.etilePoint = etilePoint;
    }

    public String getEtileType() {
        return etileType;
    }

    public void setEtileType(String etileType) {
        this.etileType = etileType;
    }

    public Integer getEtileNo() {
        return etileNo;
    }

    public void setEtileNo(Integer etileNo) {
        this.etileNo = etileNo;
    }

    public String getEtitleQuestion() {
        return etitleQuestion;
    }

    public void setEtitleQuestion(String etitleQuestion) {
        this.etitleQuestion = etitleQuestion;
    }

    public String getEtitleAnswer() {
        return etitleAnswer;
    }

    public void setEtitleAnswer(String etitleAnswer) {
        this.etitleAnswer = etitleAnswer;
    }

    public Integer getEtileNoAli() {
        return etileNoAli;
    }

    public void setEtileNoAli(Integer etileNoAli) {
        this.etileNoAli = etileNoAli;
    }
}
