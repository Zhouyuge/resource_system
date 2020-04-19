package com.bishe.main.vo;

import com.bishe.main.entity.Post;
/**
 * @author Kirito
 * @Date 2020/2/10 15:14
 */
public class PostVO extends Post {
    private String factoryName;

    private String factoryInfo;

    private String factoryImg;

    private String beListed;

    private String simpleName;

    private String simpleFactoryName;

    private Integer factoryId;

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryInfo() {
        return factoryInfo;
    }

    public void setFactoryInfo(String factoryInfo) {
        this.factoryInfo = factoryInfo;
    }

    public String getFactoryImg() {
        return factoryImg;
    }

    public void setFactoryImg(String factoryImg) {
        this.factoryImg = factoryImg;
    }

    public String getBeListed() {
        return beListed;
    }

    public void setBeListed(String beListed) {
        this.beListed = beListed;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getSimpleFactoryName() {
        return simpleFactoryName;
    }

    public void setSimpleFactoryName(String simpleFactoryName) {
        this.simpleFactoryName = simpleFactoryName;
    }

    @Override
    public Integer getFactoryId() {
        return factoryId;
    }

    @Override
    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }
}
