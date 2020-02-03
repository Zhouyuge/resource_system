package com.bishe.main.service.impl;

import com.bishe.main.dao.TechFileMapper;
import com.bishe.main.dao.TechnologyMapper;
import com.bishe.main.entity.TechFile;
import com.bishe.main.entity.TechFileExample;
import com.bishe.main.entity.Technology;
import com.bishe.main.entity.TechnologyExample;
import com.bishe.main.service.TechnologeService;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.vo.TechnologeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kirito
 * @Date 2020/2/1 15:55
 */
@Service
public class TechnologeServiceImpl implements TechnologeService {

    @Autowired
    private TechnologyMapper technologyMapper;

    @Autowired
    private TechFileMapper techFileMapper;

    /**
     * 分类获取技术栈详情
     * @param typeId
     * @return
     */
    @Override
    public List<TechnologeVO> getTechnologyByType(Integer typeId) {
        TechnologyExample technologyExample = new TechnologyExample();
        technologyExample.or().andTechnologyTypeEqualTo(typeId);
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        List<TechnologeVO> technologeVOS = new ArrayList<>();
        AutoMapperUtil.mappingList(technologies, technologeVOS, TechnologeVO.class);
        technologeVOS = technologeVOS.stream().map(e -> {
            if(e.getTechnologyType() == 1) {
                e.setTechnologyTypeName("语言和框架");
            } else {
                e.setTechnologyTypeName("数据存储");
            }
            return e;
        }).collect(Collectors.toList());
        return technologeVOS;
    }

    /**
     * 根据Id获取单个技术栈详情
     * @param id
     * @return
     */
    @Override
    public TechnologeVO getTechnologyById(Integer id) {
        Technology technology = technologyMapper.selectByPrimaryKey(id);
        TechnologeVO technologeVO = new TechnologeVO();
        AutoMapperUtil.mapping(technology, technologeVO);
        if(technologeVO.getTechnologyType() == 1) {
            technologeVO.setTechnologyTypeName("语言和框架");
        } else {
            technologeVO.setTechnologyTypeName("数据存储");
        }
        TechFileExample techFileExample = new TechFileExample();
        techFileExample.or().andTechnologyIdEqualTo(id);
        List<TechFile> techFiles = techFileMapper.selectByExample(techFileExample);
        techFiles = techFiles.stream().map(e -> {
            e.setSimpleName(e.getFileName().length() > 10 ? e.getFileName().substring(0, 11) + "..." : e.getFileName());
            return e;
        }).collect(Collectors.toList());
        technologeVO.setTechFileList(techFiles);
        return technologeVO;
    }

    @Override
    public int insertTechFile(TechFile techFile) {
        return techFileMapper.insertSelective(techFile);
    }
}
