package com.bishe.main.service;

import com.bishe.main.entity.Moreau;
import com.bishe.main.entity.MoreauContent;
import com.bishe.main.vo.MoreauVO;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/3/31 19:26
 */
public interface MoreauService {
    List<MoreauVO> getMoreauVOByMoreauId(Integer moreauId);

    List<Moreau> getAllMoreaus();

    MoreauContent getMoreauContent(Integer id);
}
