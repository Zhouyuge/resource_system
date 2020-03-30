package com.bishe.main.service.impl;


import com.bishe.main.dao.FactoryMapper;
import com.bishe.main.dao.PostMapper;
import com.bishe.main.entity.Factory;
import com.bishe.main.entity.Post;
import com.bishe.main.service.PostService;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.vo.PostVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kirito
 * @Date 2020/2/10 15:00
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private FactoryMapper factoryMapper;

    @Autowired
    private PostMapper postMapper;

    private static final Integer pageSize = 15;

    /**
     * 分页获取岗位详情
     * @param pageNum
     * @return
     */
    @Override
    public List<PostVO> getPostVOs(Integer pageNum) {
        Page<Post> postPage = getPosts(pageNum);
        List<PostVO> postVOS = new ArrayList<>();
        AutoMapperUtil.mappingList(postPage, postVOS, PostVO.class);
        postVOS = postVOS.stream().map(e -> {
            Factory factory = factoryMapper.selectByPrimaryKey(e.getFactoryId());
            e.setFactoryImg(factory.getFactoryImg());
            e.setFactoryInfo(factory.getFactoryInfo());
            e.setFactoryName(factory.getFactoryName());
            e.setBeListed(factory.getBeListed());
            e.setSimpleName(e.getPostName().length() > 8 ? e.getPostName().substring(0, 8) + "..." : e.getPostName());
            e.setSimpleFactoryName(factory.getFactoryName().length() > 8 ? factory.getFactoryName().substring(0, 8) + "..." : factory.getFactoryName());
            return e;
        }).collect(Collectors.toList());
        return postVOS;
    }

    /**
     * 根据分类Id分页获取圈子详情
     * @param typeId
     * @param pageNum
     * @return
     */
    @Override
    public List<PostVO> getPostVOsByTypeId(Integer typeId, Integer pageNum) {
        Page<Post> postPage = getPostsByTypeId(typeId, pageNum);
        List<PostVO> postVOS = new ArrayList<>();
        AutoMapperUtil.mappingList(postPage, postVOS, PostVO.class);
        postVOS = postVOS.stream().map(e -> {
            Factory factory = factoryMapper.selectByPrimaryKey(e.getFactoryId());
            e.setFactoryImg(factory.getFactoryImg());
            e.setFactoryInfo(factory.getFactoryInfo());
            e.setFactoryName(factory.getFactoryName());
            e.setBeListed(factory.getBeListed());
            e.setSimpleName(e.getPostName().length() > 8 ? e.getPostName().substring(0, 8) + "..." : e.getPostName());
            e.setSimpleFactoryName(factory.getFactoryName().length() > 8 ? factory.getFactoryName().substring(0, 8) + "..." : factory.getFactoryName());
            return e;
        }).collect(Collectors.toList());
        return postVOS;
    }

    /**
     * 根据id获取岗位详情
     * @param id
     * @return
     */
    @Override
    public PostVO getPostVOById(Integer id) {
        Post post = postMapper.selectByPrimaryKey(id);
        Factory factory = factoryMapper.selectByPrimaryKey(post.getFactoryId());
        PostVO postVO = new PostVO();
        AutoMapperUtil.mapping(post, postVO);
        postVO.setFactoryName(factory.getFactoryName());
        postVO.setBeListed(factory.getBeListed());
        postVO.setFactoryInfo(factory.getFactoryInfo());
        postVO.setFactoryImg(factory.getFactoryImg());
        postVO.setFactoryId(factory.getId());
        return postVO;
    }

    @Override
    public List<PostVO> getPostVOByFactoryId(Integer factoryId) {
        List<PostVO> postVOS = new ArrayList<>();
        List<Post> postList = postMapper.getPostsByFactoryId(factoryId);
        AutoMapperUtil.mappingList(postList, postVOS, PostVO.class);
        postVOS = postVOS.stream().map(e -> {
            Factory factory = factoryMapper.selectByPrimaryKey(e.getFactoryId());
            e.setFactoryImg(factory.getFactoryImg());
            e.setFactoryInfo(factory.getFactoryInfo());
            e.setFactoryName(factory.getFactoryName());
            e.setBeListed(factory.getBeListed());
            e.setSimpleName(e.getPostName().length() > 8 ? e.getPostName().substring(0, 8) + "..." : e.getPostName());
            e.setSimpleFactoryName(factory.getFactoryName().length() > 8 ? factory.getFactoryName().substring(0, 8) + "..." : factory.getFactoryName());
            return e;
        }).collect(Collectors.toList());
        return postVOS;
    }

    private Page<Post> getPosts(Integer pageNum) {
        Page<Post> postPages = PageHelper.startPage(pageNum, pageSize);
        List<Post> postList = postMapper.getPosts();
        return postPages;
    }

    private Page<Post> getPostsByTypeId(Integer typeId, Integer pageNum) {
        Page<Post> postPages = PageHelper.startPage(pageNum, pageSize);
        List<Post> postList = postMapper.getPostsByTypeId(typeId);
        return postPages;
    }


    @Override
    public Integer getPageNums(Integer typeId) {
        if(typeId != null){
            return postMapper.getPostsByTypeId(typeId).size() / pageSize + 1;
        }
        return postMapper.getPosts().size() / pageSize + 1;
    }
}
