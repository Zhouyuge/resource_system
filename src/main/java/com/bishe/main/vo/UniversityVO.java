package com.bishe.main.vo;

import com.bishe.main.entity.University;
/**
 * @author Kirito
 * @Date 2020/2/13 19:38
 */
public class UniversityVO extends University {
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
