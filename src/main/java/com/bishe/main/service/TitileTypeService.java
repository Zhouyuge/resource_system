package com.bishe.main.service;

import com.bishe.main.dto.FTypeDto;
import com.bishe.main.dto.STypeDto;
import com.bishe.main.dto.TitleDto;

import java.util.List;

/**
 * @author Kirito
 * @Date 2019/11/19 16:12
 */
public interface TitileTypeService {
    List<FTypeDto> getFTypes();

    List<STypeDto> getSTypesByFId(Integer fId);
}
