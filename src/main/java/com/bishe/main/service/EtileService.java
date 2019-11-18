package com.bishe.main.service;

import com.bishe.main.dto.EtileCategoryDto;
import com.bishe.main.dto.EtileDto;
import com.bishe.main.entity.Etile;
import com.bishe.main.entity.EtileCategory;

import java.util.List;

/**
 * @author Kirito
 * @Date 2019/11/7 11:52
 * 精华专题服务接口
 */
public interface EtileService {

    EtileDto getEtileDtoByAli(Integer no, Integer noAli);

    List<? extends Etile> getEtileDtosByNo(Integer no, Integer page, Integer num);

    int insertEtile(Etile etile);

    int updateEtile(Etile etile);

    List<EtileCategoryDto> getEtileCategorys();

    int getEtileCount(Integer categoryId);

}
