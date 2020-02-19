package com.bishe.main.enums;

/**
 * @author Kirito
 * @Date 2020/2/14 20:50
 */
public enum TitleEnum {

    SINGLE(1, "单选"),

    ASK(2, "问答");

    private final Integer KEY;

    private final String VALUE;

    TitleEnum (Integer key, String value) {
        this.KEY = key;
        this.VALUE =value;
    }

    public static Integer getKey(String value) {
        TitleEnum[] titleEnums = values();
        for(TitleEnum titleEnum : titleEnums) {
            if(titleEnum.getVALUE().equals(value)) {
                return titleEnum.getKEY();
            }
        }
        return null;
    }

    public static String getValue(Integer key) {
        TitleEnum[] titleEnums = values();
        for(TitleEnum titleEnum : titleEnums) {
            if(titleEnum.getKEY().equals(key)) {
                return titleEnum.getVALUE();
            }
        }
        return null;
    }

    public Integer getKEY() {
        return KEY;
    }

    public String getVALUE() {
        return VALUE;
    }
}
