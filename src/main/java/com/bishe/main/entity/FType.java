package com.bishe.main.entity;

import java.util.Date;

public class FType {
    private Integer typeId;

    private String typeName;

    private String typeCount;

    private Date typeCreateTime;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeCount() {
        return typeCount;
    }

    public void setTypeCount(String typeCount) {
        this.typeCount = typeCount == null ? null : typeCount.trim();
    }

    public Date getTypeCreateTime() {
        return typeCreateTime;
    }

    public void setTypeCreateTime(Date typeCreateTime) {
        this.typeCreateTime = typeCreateTime;
    }
}