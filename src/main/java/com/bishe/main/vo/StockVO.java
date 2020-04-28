package com.bishe.main.vo;

import com.bishe.main.entity.Material;
import com.bishe.main.entity.Stock;

/**
 * @author Kirito
 * @Date 2020/4/28 9:56
 */
public class StockVO extends Stock {
    // 操作类型  1.入库    2.出库
    private Integer type;

    // 操作数量
    private Integer num;

    // 资源id
    private Integer id;

    // 资源名称
    private String materialName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
