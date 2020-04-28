package com.bishe.main.vo;

import com.bishe.main.entity.Material;

/**
 * @author Kirito
 * @Date 2020/4/25 10:32
 */
public class MaterialVO extends Material {
    private String categoryName;

    private Integer oldCategoryId;

    public Integer getOldCategoryId() {
        return oldCategoryId;
    }

    public void setOldCategoryId(Integer oldCategoryId) {
        this.oldCategoryId = oldCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
