package com.bishe.main.vo;

import com.bishe.main.entity.Invitation;
import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/23 19:48
 */
public class InvitationVO extends Invitation {
    private String userVisualName;

    private String userImg;

    private String simpleName;

    private List<String> labels;

    public String getUserVisualName() {
        return userVisualName;
    }

    public void setUserVisualName(String userVisualName) {
        this.userVisualName = userVisualName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
