package com.bishe.main.service;

import com.bishe.main.entity.MaterialCategory;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/4/24 16:20
 */
public interface CategoryService {

    Page<MaterialCategory> getCategorys(Integer pageNum);

    Long getCount();

    List<MaterialCategory> getAll();

    Integer deleteById(Integer id);

    Integer insertCategory(MaterialCategory materialCategroy);

    Integer updateCategory(MaterialCategory materialCategroy);

    MaterialCategory getOneById(Integer id);

    Page<MaterialCategory> getCategorysByLike(String str, Integer pageNum);
}
