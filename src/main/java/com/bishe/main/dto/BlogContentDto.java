package com.bishe.main.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author Kirito
 * @Date 2019/11/12 11:38
 */
@Data
public class BlogContentDto {
    private Integer blogCenterId;

    private String blogCenterName;

    private String blogCenterAuthor;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date blogCenterEditTime;

    private Integer blogCenterAgree;

    private Integer blogCenterCollect;

    private String blogCenterContent;

    private String blogCenterPic;
}
