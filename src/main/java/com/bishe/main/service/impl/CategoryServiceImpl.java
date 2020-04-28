package com.bishe.main.service.impl;

import com.bishe.main.entity.MaterialCategory;
import com.bishe.main.mapper.MaterialCategoryMapper;
import com.bishe.main.service.CategoryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Kirito
 * @Date 2020/4/24 16:21
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private MaterialCategoryMapper categroyMapper;

    private Long count;

    // 每页10个数据
    private final Integer PAGE_SIZE = 10;
    /**
     * 分页获取资源类别
     * @param pageNum
     * @return
     */
    @Override
    public Page<MaterialCategory> getCategorys(Integer pageNum) {
        Page<MaterialCategory> pages = PageHelper.startPage(pageNum, PAGE_SIZE);
        List<MaterialCategory> categroys = categroyMapper.getMaterialCategorys();
        count = pages.getTotal();
        return pages;
    }

    /**
     * 获取类别总数
     * @return
     */
    @Override
    public Long getCount() {
        return count;
    }

    /**
     * 删除资源分类
     * @param id
     * @return
     */
    @Override
    public Integer deleteById(Integer id) {
        return categroyMapper.deleteByPrimaryKey(id);
    }

    /**
     * 插入资源分类
     * @param materialCategroy
     * @return
     */
    @Override
    public Integer insertCategory(MaterialCategory materialCategroy) {
        materialCategroy.setCreateTime(new Date());
        materialCategroy.setCategoryCount(0);
        int result = categroyMapper.insertSelective(materialCategroy);
        return result;
    }

    /**
     * 更新资源分类
     * @param materialCategroy
     * @return
     */
    @Override
    public Integer updateCategory(MaterialCategory materialCategroy) {
        return categroyMapper.updateByPrimaryKeySelective(materialCategroy);
    }

    /**
     * 根据id获取资源分类信息
     * @param id
     * @return
     */
    @Override
    public MaterialCategory getOneById(Integer id) {
        return categroyMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页获取模糊查询结果
     * @param str
     * @param pageNum
     * @return
     */
    @Override
    public Page<MaterialCategory> getCategorysByLike(String str, Integer pageNum) {
        Page<MaterialCategory> pages = PageHelper.startPage(pageNum, PAGE_SIZE);
        List<MaterialCategory> categroys = categroyMapper.getMaterialCategorysByLike(str);
        count = pages.getTotal();
        return pages;
    }

    @Override
    public List<MaterialCategory> getAll() {
        return categroyMapper.getMaterialCategorys();
    }
}
