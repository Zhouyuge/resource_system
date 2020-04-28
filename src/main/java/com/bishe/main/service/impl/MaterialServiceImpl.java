package com.bishe.main.service.impl;

import com.bishe.main.entity.Material;
import com.bishe.main.entity.MaterialCategory;
import com.bishe.main.entity.Stock;
import com.bishe.main.mapper.MaterialCategoryMapper;
import com.bishe.main.mapper.MaterialMapper;
import com.bishe.main.mapper.StockMapper;
import com.bishe.main.service.CategoryService;
import com.bishe.main.service.MaterialService;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.vo.MaterialVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * @author Kirito
 * @Date 2020/4/25 10:37
 */
@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialMapper materialMapper;

    @Autowired
    private MaterialCategoryMapper categroyMapper;

    @Autowired
    private StockMapper stockMapper;

    private final Integer PAGE_SIZE = 10;

    private Long count;

    @Override
    public Page<MaterialVO> getMaterialVOs(String str, Integer pageNum) {
        Page<MaterialVO> page = PageHelper.startPage(pageNum, PAGE_SIZE);
        List<MaterialVO> materialVOS = materialMapper.getMaterials(str);
        count = page.getTotal();
        return page;
    }

    @Override
    public Long getCount() {
        return this.count;
    }

    @Transactional
    @Override
    public Integer insertMaterial(Material material) {
        material.setCreateTime(new Date());
        MaterialCategory mc = categroyMapper.selectByPrimaryKey(material.getCategoryId());
        // 更新资源下数量
        mc.setCategoryCount(mc.getCategoryCount() + 1);
        categroyMapper.updateByPrimaryKeySelective(mc);
        int result = materialMapper.insertSelective(material);
        // 添加库存
        if (result > 0) {
            Stock stock = new Stock();
            stock.setResourceId(material.getId());
            stock.setEditTime(new Date());
            stockMapper.insertSelective(stock);
        }
        return result;
    }

    @Transactional
    @Override
    public Integer updateMaterial(MaterialVO materialVO) {
        // 如果类别修改，则旧类别数量 - 1
        MaterialCategory mc = categroyMapper.selectByPrimaryKey(materialVO.getOldCategoryId());
        mc.setCategoryCount(mc.getCategoryCount() - 1);
        categroyMapper.updateByPrimaryKeySelective(mc);
        // 新类别数量 + 1
        mc = categroyMapper.selectByPrimaryKey(materialVO.getCategoryId());
        mc.setCategoryCount(mc.getCategoryCount() + 1);
        categroyMapper.updateByPrimaryKeySelective(mc);

        Material material = new Material();
        AutoMapperUtil.mapping(materialVO, material);
        return materialMapper.updateByPrimaryKeySelective(material);
    }

    @Transactional
    @Override
    public Integer deleteMaterial(Integer id) {
        MaterialCategory mc = categroyMapper.selectByPrimaryKey(materialMapper.selectByPrimaryKey(id).getCategoryId());
        // 更新资源下数量
        mc.setCategoryCount(mc.getCategoryCount() - 1);
        categroyMapper.updateByPrimaryKeySelective(mc);

        stockMapper.deleteByResouceId(mc.getId());
        return materialMapper.deleteByPrimaryKey(id);
    }

    @Override
    public MaterialVO getMaterial(Integer id) {
        Material material = materialMapper.selectByPrimaryKey(id);
        // 实体类和VO类交换数据
        MaterialVO materialVO = new MaterialVO();
        AutoMapperUtil.mapping(material, materialVO);
        materialVO.setCategoryName(categroyMapper.selectByPrimaryKey(id).getCategoryName());
        return materialVO;
    }
}
