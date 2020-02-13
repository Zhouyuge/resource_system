package com.bishe.main.dao;

import com.bishe.main.entity.Post;

import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

    List<Post> getPosts();

    List<Post> getPostsByTypeId(Integer typeId);

    List<Post> getPostsByFactoryId(Integer factoryId);
}