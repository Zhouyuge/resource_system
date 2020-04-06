package com.bishe.main.vo;

import com.bishe.main.entity.MoreauChap;
import com.bishe.main.entity.MoreauContent;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/3/31 19:19
 */
public class MoreauVO extends MoreauChap {

    private List<MoreauContent> moreauContents;

    public List<MoreauContent> getMoreauContents() {
        return moreauContents;
    }

    public void setMoreauContents(List<MoreauContent> moreauContents) {
        this.moreauContents = moreauContents;
    }
}
