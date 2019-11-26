package com.bishe.main.dto;

import lombok.Data;

/**
 * @author Kirito
 * @Date 2019/11/19 16:13
 */
@Data
public class STypeDto {
    private Integer typeId;

    private Integer typeFId;

    private String typeName;

    private String typeCount;

    private String doCount;     //已做题的数量
}
