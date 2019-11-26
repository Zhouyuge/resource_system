package com.bishe.main.service.impl;

import cn.hutool.core.convert.Convert;
import com.bishe.main.dao.FTypeMapper;
import com.bishe.main.dao.STypeMapper;
import com.bishe.main.dto.FTypeDto;
import com.bishe.main.dto.STypeDto;
import com.bishe.main.dto.TitleDto;
import com.bishe.main.entity.*;
import com.bishe.main.service.TitileTypeService;
import com.bishe.main.util.AutoMapperUtil;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kirito
 * @Date 2019/11/19 16:17
 */
@Service
@Transactional
public class TitleTypeServiceImpl implements TitileTypeService {
    @Autowired
    private FTypeMapper fTypeMapper;

    @Autowired
    private STypeMapper sTypeMapper;

    private static Integer rightCount = 0;      //对题总数

    private static Integer wrongCount = 0;      //错题总数

    @Override
    public List<FTypeDto> getFTypes() {
        FTypeExample fTypeExample = new FTypeExample();
        List<FType> fTypes = fTypeMapper.selectByExample(fTypeExample);
        if (fTypes.size() > 0) {
            List<FTypeDto> fTypeDtos = new ArrayList<>();
            AutoMapperUtil.mappingList(fTypes, fTypeDtos, FTypeDto.class);
            return fTypeDtos;
        }
        return null;
    }

    @Override
    public List<STypeDto> getSTypesByFId(Integer fId) {
        STypeExample sTypeExample = new STypeExample();
        sTypeExample.or().andTypeFIdEqualTo(fId);
        List<SType> sTypes = sTypeMapper.selectByExample(sTypeExample);
        if (sTypes.size() > 0){
            List<STypeDto> sTypeDtos = new ArrayList<>();
            AutoMapperUtil.mappingList(sTypes, sTypeDtos, STypeDto.class);
            return sTypeDtos;
        }
        return null;
    }

}
