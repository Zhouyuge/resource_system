package com.bishe.main.service.impl;

import com.bishe.main.dao.BlogCenterMapper;
import com.bishe.main.dto.BlogContentDto;
import com.bishe.main.dto.BlogDto;
import com.bishe.main.entity.BlogCenter;
import com.bishe.main.entity.BlogCenterExample;
import com.bishe.main.service.BlogCenterService;
import com.bishe.main.util.AutoMapperUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.ListableBeanFactoryExtensionsKt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kirito
 * @Date 2019/11/12 11:37
 */

@Service
public class BlogCenterServiceImpl implements BlogCenterService {
    @Autowired
    private BlogCenterMapper blogCenterMapper;

    private final Integer num = 10;

    @Override
    public Page<BlogCenter> getBlogDtos(Integer page, Integer num) {
        num = this.num;
        Page<BlogCenter> blogCenters = PageHelper.startPage(page, num); //分页
        BlogCenterExample blogCenterExample = new BlogCenterExample();
        blogCenterExample.setOrderByClause("blog_center_edit_time DESC");   //按时间降序
        List<BlogCenter> blogCenterList = blogCenterMapper.selectByExample(blogCenterExample);
        return blogCenters;
    }

    @Override
    public BlogContentDto getBlogContentDtoById(Integer id) {
        BlogCenter blogCenter = blogCenterMapper.selectByPrimaryKey(id);
        if (blogCenter != null) {
            BlogContentDto blogContentDto = new BlogContentDto();
            AutoMapperUtil.mapping(blogCenter, blogContentDto);
            return blogContentDto;
        }
        return null;
    }

    public Integer getPages() {
        return blogCenterMapper.selectByExample(new BlogCenterExample()).size() > 0
                ? blogCenterMapper.selectByExample(new BlogCenterExample()).size() / num + 1
                : 0;
    }
}
