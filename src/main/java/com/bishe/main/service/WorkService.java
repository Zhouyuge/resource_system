package com.bishe.main.service;

import com.bishe.main.vo.SelfDetailVO;

/**
 * @author Kirito
 * @Date 2020/1/7 17:10
 * 工作Service
 */
public interface WorkService {
    Integer generatorPdf(SelfDetailVO selfDetailVO, String userId);
}
