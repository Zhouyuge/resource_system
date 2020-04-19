package com.bishe.main.dto;

/**
 * @author Kirito
 * @Date 2019/11/19 16:13
 */
public class STypeDto {
    private Integer typeId;

    private Integer typeFId;

    private String typeName;

    private String typeCount;

    private String doCount;     //已做题的数量

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeFId() {
        return typeFId;
    }

    public void setTypeFId(Integer typeFId) {
        this.typeFId = typeFId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeCount() {
        return typeCount;
    }

    public void setTypeCount(String typeCount) {
        this.typeCount = typeCount;
    }

    public String getDoCount() {
        return doCount;
    }

    public void setDoCount(String doCount) {
        this.doCount = doCount;
    }
}
