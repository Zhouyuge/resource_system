package com.bishe.main.vo;

import com.bishe.main.entity.Circle;
import lombok.Data;

/**
 * @author Kirito
 * @Date 2020/2/4 19:46
 */
@Data
public class CircleVO  extends Circle {
        private String userName;

        private String userHeadPic;

        private String typeValue;
}
