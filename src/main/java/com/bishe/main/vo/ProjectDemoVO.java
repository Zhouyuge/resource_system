package com.bishe.main.vo;

import com.bishe.main.entity.ProjectDemo;
import java.util.Date;

/**
 * @author Kirito
 * @Date 2020/2/20 18:09
 */
public class ProjectDemoVO extends ProjectDemo {
    private String userVisualName;

    private String userHeadPic;

    public String getUserVisualName() {
        return userVisualName;
    }

    public void setUserVisualName(String userVisualName) {
        this.userVisualName = userVisualName;
    }

    public String getUserHeadPic() {
        return userHeadPic;
    }

    public void setUserHeadPic(String userHeadPic) {
        this.userHeadPic = userHeadPic;
    }
}