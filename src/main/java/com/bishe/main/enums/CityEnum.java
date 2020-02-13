package com.bishe.main.enums;

/**
 * @author Kirito
 * @Date 2020/2/13 15:11
 */
public enum CityEnum {
    BEI_JING(1, "北京"),
    SHANG_HAI(2, "上海"),
    JI_LING(3, "吉林"),
    LIAO_NING(4, "辽宁"),
    AN_HUI(5, "安徽"),
    JIANG_SU(6, "江苏"),
    ZHE_JIANG(7, "浙江"),
    SHANG_XI(8, "陕西"),
    HU_BEI(9, "湖北"),
    GUANG_DONG(10, "广东"),
    HU_NAN(11, "湖南"),
    GAN_SU(12, "甘肃"),
    SI_CHUANG(13, "四川"),
    SHANG_DONG(14, "山东"),
    FU_JIAN(15, "福建"),
    CHONG_QING(16, "重庆");
    ;

    private final Integer KEY;

    private final String VALUE;

    CityEnum(Integer key, String value) {
        this.KEY = key;
        this.VALUE =value;
    }

    public static Integer getKey(String value) {
        CityEnum[] cityEnums = values();
        for(CityEnum cityEnum : cityEnums) {
            if(cityEnum.getVALUE().equals(value)) {
                return cityEnum.getKEY();
            }
        }
        return null;
    }

    public static String getValue(Integer key) {
        CityEnum[] cityEnums = values();
        for(CityEnum cityEnum : cityEnums) {
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
