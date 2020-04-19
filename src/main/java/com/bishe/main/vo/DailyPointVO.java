package com.bishe.main.vo;

import com.bishe.main.entity.DailyPoint;
import com.bishe.main.entity.User;
/**
 * @author Kirito
 * @Date 2020/2/28 13:03
 */
public class DailyPointVO extends DailyPoint {
    private User user;

    private String prettyTime;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPrettyTime() {
        return prettyTime;
    }

    public void setPrettyTime(String prettyTime) {
        this.prettyTime = prettyTime;
    }
}
