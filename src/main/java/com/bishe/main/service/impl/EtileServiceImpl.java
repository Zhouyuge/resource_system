package com.bishe.main.service.impl;

import com.bishe.main.dao.EtileCategoryMapper;
import com.bishe.main.dao.EtileMapper;
import com.bishe.main.dto.EtileCategoryDto;
import com.bishe.main.dto.EtileDto;
import com.bishe.main.entity.*;
import com.bishe.main.service.EtileService;
import com.bishe.main.util.AutoMapperUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirito
 * @Date 2019/11/7 11:55
 * 服务接口实现类
 */
@Service
public class EtileServiceImpl implements EtileService {
    @Autowired
    private EtileMapper etileMapper;
    @Autowired
    private EtileCategoryMapper etileCategoryMapper;

    @Override
    public EtileDto getEtileDtoByAli(Integer no, Integer noAli) {
        EtileExample etileExample = new EtileExample();
        etileExample.or().andEtileNoEqualTo(no).andEtileNoAliEqualTo(noAli);
        List<EtileWithBLOBs> etileWithBLOBs = etileMapper.selectByExampleWithBLOBs(etileExample);
        if (etileWithBLOBs.size() == 1) {
            EtileDto etileDto = new EtileDto();
            AutoMapperUtil.mapping(etileWithBLOBs.get(0), etileDto);       //dto和实体类转换
            return etileDto;
        }
        return null;
    }

    @Override
    @Transactional
    public Page<? extends Etile> getEtileDtosByNo(Integer no, Integer page, Integer num) {
        Page<? extends Etile> etileDtoPage = PageHelper.startPage(page, num);  //分页

        EtileExample etileExample = new EtileExample();
        etileExample.or().andEtileNoEqualTo(no);
        List<? extends Etile> etiles = etileMapper.selectByExampleWithBLOBs(etileExample);  //获取题目全部信息

        return etileDtoPage;
    }

    @Override
    public int insertEtile(Etile etile) {
        return 0;
    }

    @Override
    public int updateEtile(Etile etile) {
        return 0;
    }

    @Override
    public List<EtileCategoryDto> getEtileCategorys() {
        List<EtileCategory> etileCategories = etileCategoryMapper.selectByExample(new EtileCategoryExample());
        List<EtileCategoryDto> etileCategoryDtos = new ArrayList<>();

        AutoMapperUtil.mappingList(etileCategories, etileCategoryDtos, EtileCategoryDto.class);

        if (etileCategoryDtos.size() > 0) {
            return etileCategoryDtos;
        } else {
            return null;
        }
    }

    @Override
    public int getEtileCount(Integer categoryId) {
        EtileExample etileExample = new EtileExample();
        etileExample.or().andEtileNoEqualTo(categoryId);
        List<Etile> etiles = etileMapper.selectByExample(etileExample); //获取分类Id下的标题
        int size = etiles.size();
        if (size > 0) {                      //正常获取文章大小
            return size;
        }
        return 0;
    }
}
