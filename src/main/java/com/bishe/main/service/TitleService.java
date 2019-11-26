package com.bishe.main.service;

import com.bishe.main.dto.TitleDto;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Kirito
 * @Date 2019/11/20 15:21
 */
public interface TitleService {

    List<TitleDto> getTitleDtos(String uId);

    int updateTitle(List<TitleDto> titleDtos, String userId );

    Integer getDoTitleCount(String userId);

}
