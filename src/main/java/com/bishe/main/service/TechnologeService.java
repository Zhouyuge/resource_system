package com.bishe.main.service;

import com.bishe.main.entity.TechFile;
import com.bishe.main.entity.Technology;
import com.bishe.main.vo.TechnologeVO;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/1 15:55
 */

public interface TechnologeService {
    List<TechnologeVO> getTechnologyByType(Integer typeId);

    TechnologeVO getTechnologyById(Integer Id);

    int insertTechFile(TechFile techFile);
}
