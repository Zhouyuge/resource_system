package com.bishe.main.service;

import com.bishe.main.entity.Factory;
import com.bishe.main.vo.PostVO;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/10 15:00
 */
public interface PostService {
    List<PostVO> getPostVOs(Integer pageNum);

    List<PostVO> getPostVOsByTypeId(Integer typeId, Integer pageNum);

    PostVO getPostVOById(Integer id);

    List<PostVO> getPostVOByFactoryId(Integer factoryId);
}
