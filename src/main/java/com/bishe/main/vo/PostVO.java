package com.bishe.main.vo;

import com.bishe.main.entity.Post;
import lombok.Data;

/**
 * @author Kirito
 * @Date 2020/2/10 15:14
 */
@Data
public class PostVO extends Post {
    private String factoryName;

    private String factoryInfo;

    private String factoryImg;

    private String beListed;

    private String simpleName;

    private String simpleFactoryName;

    private Integer factoryId;
}
