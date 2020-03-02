package com.bishe.main.service;

import com.bishe.main.vo.DailyPointVO;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author Kirito
 * @Date 2019/11/15 16:23
 */
public interface UserService {
    String queryUserByToken(String token);

    void logout(String token);

    Page<DailyPointVO> getAllDailyPointVO(Integer pageNum);

    int addDailyPoint(DailyPointVO dailyPointVO, String userId);

    int pageCount();
}
