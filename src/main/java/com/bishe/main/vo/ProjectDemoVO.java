package com.bishe.main.vo;

import com.bishe.main.entity.ProjectDemo;
import lombok.Data;

import java.util.Date;

/**
 * @author Kirito
 * @Date 2020/2/20 18:09
 */
@Data
public class ProjectDemoVO extends ProjectDemo {
    private String userVisualName;

    private String userHeadPic;

}