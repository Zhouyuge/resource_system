package com.bishe.main.dto;

import lombok.Data;

/**
 * @author Kirito
 * @Date 2019/11/7 12:00
 */
@Data
public class EtileDto {
    private Integer etileId;    //id

    private String etileName;   //标题

    private String etilePoint;  //要点

    private String etileType;   //类型

    private Integer etileNo;    //分类Id

    private String etitleQuestion;  //问题

    private String etitleAnswer;    //答案

    private Integer etileNoAli;     //题目别名
}
