package com.bishe.main.service;

import com.bishe.main.entity.Circle;
import com.bishe.main.vo.CircleVO;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/4 19:52
 *  圈子服务接口
 */

public interface CircleService {
    Page<Circle> getCircleVOs(Integer pageNum);

    Page<Circle> getCircleVOSByTypeId(Integer typeId, Integer pageNum);

    CircleVO getCircleVOById(Integer id);
}
