package com.bishe.main.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author Kirito
 * @Date 2019/11/7 15:43
 */
@Data
public class EtileCategoryDto {
    private Integer etileCategoryId;

    private String etileCategoryName;

    private Integer etileCategoryNum;

    private String etileCategoryPhoto;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS", timezone = "GMT+8")
    private Date etileCategoryEditTime;
}
