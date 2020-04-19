package com.bishe.main;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author Kirito
 * @Date 2020/4/18 10:01
 */
public class Item extends BaseRowModel {
    @ExcelProperty(value = "交易所", index = 0)
    private String housetext;

    @ExcelProperty(value = "交易类型", index = 1)
    private String subTypeName;

    @ExcelProperty(value = "交易日期", index = 2)
    private String indate;

    @ExcelProperty(value = "成交价(元)", index = 3)
    private double deal;

    @ExcelProperty(value = "交易额(元)", index = 4)
    private double dealamount;

    @ExcelProperty(value = "交易量(吨)", index = 5)
    private Integer dealnum;

    @Override
    public String toString() {
        return "Item{" +
                "housetext='" + housetext + '\'' +
                ", subTypeName='" + subTypeName + '\'' +
                ", indate='" + indate + '\'' +
                ", deal=" + deal +
                ", dealamount=" + dealamount +
                ", dealnum=" + dealnum +
                '}';
    }

    public String getHousetext() {
        return housetext;
    }

    public void setHousetext(String housetext) {
        this.housetext = housetext;
    }

    public String getSubTypeName() {
        return subTypeName;
    }

    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public double getDeal() {
        return deal;
    }

    public void setDeal(double deal) {
        this.deal = deal;
    }

    public double getDealamount() {
        return dealamount;
    }

    public void setDealamount(double dealamount) {
        this.dealamount = dealamount;
    }

    public Integer getDealnum() {
        return dealnum;
    }

    public void setDealnum(Integer dealnum) {
        this.dealnum = dealnum;
    }
}
