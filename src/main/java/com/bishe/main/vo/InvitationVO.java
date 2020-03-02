package com.bishe.main.vo;

import com.bishe.main.entity.Invitation;
import lombok.Data;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/23 19:48
 */
@Data
public class InvitationVO extends Invitation {
    private String userVisualName;

    private String userImg;

    private String simpleName;

    private List<String> labels;
}
