package com.bishe.main.service;

import com.bishe.main.entity.Paper;
import com.bishe.main.entity.PaperTitle;
import com.bishe.main.entity.University;
import com.bishe.main.vo.PaperVO;
import com.bishe.main.vo.UniversityVO;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/13 19:39
 */
public interface UniversityService {
    List<UniversityVO> getUniversityVOsByCityId(String cityName);

    UniversityVO getUniVersityById(Integer id);

    List<PaperVO> getPapersByUniId(Integer uniId);

    Page<PaperTitle> getPaperTitles(Integer paperId, Integer pageNum);

    PaperTitle getPaperTitleById(Integer id);
}
