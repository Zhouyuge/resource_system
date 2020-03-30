package com.bishe.main.entity.result;

import lombok.Data;

import java.util.Date;

/**
 * @author Kirito
 * @Date 2020/3/9 21:18
 */
@Data
public class TokenResult {
    private Integer code;

    private String userId;

    private String token;

    private String userName;

    private String userPortrait;

    private Date createTime;
}
