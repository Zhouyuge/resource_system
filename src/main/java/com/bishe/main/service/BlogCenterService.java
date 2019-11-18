package com.bishe.main.service;

import com.bishe.main.dto.BlogContentDto;
import com.bishe.main.dto.BlogDto;
import com.bishe.main.entity.BlogCenter;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.ListableBeanFactoryExtensionsKt;

/**
 * @author Kirito
 * @Date 2019/11/12 11:37
 */
public interface BlogCenterService {
    Page<BlogCenter> getBlogDtos(Integer page, Integer num);

    BlogContentDto getBlogContentDtoById(Integer id);
}
