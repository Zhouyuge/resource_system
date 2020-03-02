package com.bishe.main.enums;

/**
 * @author Kirito
 * @Date 2020/2/13 15:11
 */
public enum InviEnum {
    ZHAN_NEI_GONG_GAO(1, "站内公告"),
    BI_JING(2, "笔经面经"),
    TI_WEN(3, "我要提问"),
    JI_SHU(4, "技术交流"),
    CHAN_PIN(5, "产品运营"),
    LIU_XUE(6, "留学生"),
    ZHI_YE(7, "职业发展"),
    ZHAO_PIN(8, "招聘信息"),
    ZI_YUAN(9, "资源分享"),
    YUANG(10, "猿生活"),
    GONG_ZUO(11, "工作以后");

    private final Integer KEY;

    private final String VALUE;

    InviEnum(Integer key, String value) {
        this.KEY = key;
        this.VALUE =value;
    }

    public static Integer getKey(String value) {
        InviEnum[] cityEnums = values();
        for(InviEnum cityEnum : cityEnums) {
            if(cityEnum.getVALUE().equals(value)) {
                return cityEnum.getKEY();
            }
        }
        return null;
    }

    public static String getValue(Integer key) {
        InviEnum[] cityEnums = values();
        for(InviEnum cityEnum : cityEnums) {
            if(cityEnum.getKEY().equals(key)) {
                return cityEnum.getVALUE();
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
