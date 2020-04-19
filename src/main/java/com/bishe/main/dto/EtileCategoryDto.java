package com.bishe.main.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @author Kirito
 * @Date 2019/11/7 15:43
 */
public class EtileCategoryDto {
    private Integer etileCategoryId;

    private String etileCategoryName;

    private Integer etileCategoryNum;

    private String etileCategoryPhoto;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS", timezone = "GMT+8")
    private Date etileCategoryEditTime;

    public Integer getEtileCategoryId() {
        return etileCategoryId;
    }

    public void setEtileCategoryId(Integer etileCategoryId) {
        this.etileCategoryId = etileCategoryId;
    }

    public String getEtileCategoryName() {
        return etileCategoryName;
    }

    public void setEtileCategoryName(String etileCategoryName) {
        this.etileCategoryName = etileCategoryName;
    }

    public Integer getEtileCategoryNum() {
        return etileCategoryNum;
    }

    public void setEtileCategoryNum(Integer etileCategoryNum) {
        this.etileCategoryNum = etileCategoryNum;
    }

    public String getEtileCategoryPhoto() {
        return etileCategoryPhoto;
    }

    public void setEtileCategoryPhoto(String etileCategoryPhoto) {
        this.etileCategoryPhoto = etileCategoryPhoto;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS", timezone = "GMT+8")
    public Date getEtileCategoryEditTime() {
        return etileCategoryEditTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS", timezone = "GMT+8")
    public void setEtileCategoryEditTime(Date etileCategoryEditTime) {
        this.etileCategoryEditTime = etileCategoryEditTime;
    }
}
