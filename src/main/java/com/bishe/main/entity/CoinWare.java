package com.bishe.main.entity;

public class CoinWare {
    private Integer coinWareId;

    private String coinWareName;

    private Integer coinWarePrice;

    private Integer coinWareNum;

    private Integer coinWareType;

    private String coinWareBigPic;

    public Integer getCoinWareId() {
        return coinWareId;
    }

    public void setCoinWareId(Integer coinWareId) {
        this.coinWareId = coinWareId;
    }

    public String getCoinWareName() {
        return coinWareName;
    }

    public void setCoinWareName(String coinWareName) {
        this.coinWareName = coinWareName == null ? null : coinWareName.trim();
    }

    public Integer getCoinWarePrice() {
        return coinWarePrice;
    }

    public void setCoinWarePrice(Integer coinWarePrice) {
        this.coinWarePrice = coinWarePrice;
    }

    public Integer getCoinWareNum() {
        return coinWareNum;
    }

    public void setCoinWareNum(Integer coinWareNum) {
        this.coinWareNum = coinWareNum;
    }

    public Integer getCoinWareType() {
        return coinWareType;
    }

    public void setCoinWareType(Integer coinWareType) {
        this.coinWareType = coinWareType;
    }

    public String getCoinWareBigPic() {
        return coinWareBigPic;
    }

    public void setCoinWareBigPic(String coinWareBigPic) {
        this.coinWareBigPic = coinWareBigPic == null ? null : coinWareBigPic.trim();
    }
}