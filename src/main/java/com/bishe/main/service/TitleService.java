package com.bishe.main.service;

import com.bishe.main.dto.TitleDto;
import com.bishe.main.entity.SelectTitle;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Kirito
 * @Date 2019/11/20 15:21
 */
public interface TitleService {

    List<TitleDto> getTitleDtos(String uId, Integer sType);

    int updateTitle(List<TitleDto> titleDtos, String userId );

    Integer getDoTitleCount(String userId);

    List<SelectTitle> getWrongDtos(String userId);
}
