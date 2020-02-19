package com.bishe.main.service.impl;

import com.bishe.main.dao.PaperMapper;
import com.bishe.main.dao.PaperTitleMapper;
import com.bishe.main.dao.UniversityMapper;
import com.bishe.main.entity.Paper;
import com.bishe.main.entity.PaperTitle;
import com.bishe.main.entity.University;
import com.bishe.main.enums.CityEnum;
import com.bishe.main.service.UniversityService;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.vo.PaperVO;
import com.bishe.main.vo.UniversityVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kirito
 * @Date 2020/2/13 19:40
 */
@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityMapper universityMapper;

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private PaperTitleMapper paperTitleMapper;

    private final Integer pageSize = 20;

    /**
     * 获取城市下的所有大学
     * @param cityName
     * @return
     */
    @Override
    public List<UniversityVO> getUniversityVOsByCityId(String cityName) {
        Integer cityId = CityEnum.getKey(cityName);
        List<University> universityList = universityMapper.getByCityId(cityId);
        List<UniversityVO> universityVOS = new ArrayList<>();
        AutoMapperUtil.mappingList(universityList, universityVOS, UniversityVO.class);
        universityVOS = universityVOS.stream().map(e -> {e.setCityName(cityName); return e;}).collect(Collectors.toList());
        return universityVOS;
    }

    /**
     * 根据id获取大学详情
     * @param id
     * @return
     */
    @Override
    public UniversityVO getUniVersityById(Integer id) {
        University university = universityMapper.selectByPrimaryKey(id);
        UniversityVO universityVO = new UniversityVO();
        AutoMapperUtil.mapping(university, universityVO);
        return universityVO;
    }

    /**
     * 根据大学id获取试卷列表
     * @param uniId
     * @return
     */
    @Override
    public List<PaperVO> getPapersByUniId(Integer uniId) {
        List<Paper> papers = paperMapper.getPapersByUni(uniId);
        University university = universityMapper.selectByPrimaryKey(uniId);
        List<PaperVO> paperVOS = new ArrayList<>();
        AutoMapperUtil.mappingList(papers, paperVOS, PaperVO.class);
        paperVOS.forEach(e->e.setUniName(university.getUniverName()));
        return paperVOS;
    }

    /**
     * 分页获取试卷详情
     * @param paperId
     * @param pageNum
     * @return
     */
    @Override
    public Page<PaperTitle> getPaperTitles(Integer paperId, Integer pageNum) {
        Page<PaperTitle> paperTitlePage = PageHelper.startPage(pageNum, pageSize);
        List<PaperTitle> paperTitles = paperTitleMapper.getPaperTitlesByPaperId(paperId);
        return paperTitlePage;
    }

    /**
     * 根据id获取试题详情
     * @param id
     * @return
     */
    @Override
    public PaperTitle getPaperTitleById(Integer id) {
        return paperTitleMapper.selectByPrimaryKey(id);
    }
}
