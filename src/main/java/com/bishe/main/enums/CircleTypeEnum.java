package com.bishe.main.enums;

/**
 * @author Kirito
 * @Date 2019/11/13 11:08
 */

public enum CircleTypeEnum {
    STYDU(1, "学习"),
    WORK(2, "求职"),
    FACTORY(3, "公司"),
    NGEE(4, "考研"),
    COMPETE(5, "竞赛"),
    LIFE(6, "生活"),
    STUDY_ABORD(7, "留学");
    private Integer id;
    private String value;

    CircleTypeEnum(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}

