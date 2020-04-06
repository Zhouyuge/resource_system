package com.bishe.main.service;

import com.bishe.main.entity.User;
import com.bishe.main.ro.LoginRo;
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

    List<DailyPointVO> getDailyPointVOByUserId(String userId);

    int deleteDailyPointById(Integer id);

    int addDailyPoint(DailyPointVO dailyPointVO, String userId);

    int updateUserInfo(User user);

    int pageCount();

    User getUserByPrimaryKey(String userId);

    List<User> getAllUsers();

    LoginRo registerUser(String email, String password);

    LoginRo updateUser(User user, String token);

    User getUser(User user);

    User getUserById(String userId);
}
