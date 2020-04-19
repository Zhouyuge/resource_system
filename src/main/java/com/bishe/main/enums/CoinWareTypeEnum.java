package com.bishe.main.enums;

/**
 * @author Kirito
 * @Date 2019/11/13 11:08
 */

public enum CoinWareTypeEnum {
    SPECIAL(1, "牛客定制"),
    HOT_WARE(2, "热门商品"),
    FACTORY(3, "名企周边"),
    BOOKS(4, "专业书籍");

    private Integer id;
    private String value;

    CoinWareTypeEnum(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
