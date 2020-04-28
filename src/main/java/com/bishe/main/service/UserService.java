package com.bishe.main.service;

import com.bishe.main.entity.User;
import com.bishe.main.vo.UserVO;

/**
 * @author Kirito
 * @Date 2020/4/24 9:45
 */
public interface UserService {
    User login(UserVO user);
}
