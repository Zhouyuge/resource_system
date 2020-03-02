package com.bishe.main.vo;

import com.bishe.main.entity.DailyPoint;
import com.bishe.main.entity.User;
import lombok.Data;

/**
 * @author Kirito
 * @Date 2020/2/28 13:03
 */
@Data
public class DailyPointVO extends DailyPoint {
    private User user;

    private String prettyTime;
}
