package com.bishe.main.dto;

import com.bishe.main.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author Kirito
 * @Date 2019/11/12 11:38
 */
@Data
public class BlogDto {
    private Integer blogCenterId;

    private String blogCenterName;

    private String blogCenterAuthor;

    private String blogCenterPic;

    private Integer blogCenterAgree;

    private Integer blogCenterCollect;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS", timezone = "GMT+8")
    private Date blogCenterEditTime;

    private String blogCenterVlog;

    private User user;

    private String prettyTime;
}
