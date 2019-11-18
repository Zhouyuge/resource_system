package com.bishe.main.service;

/**
 * @author Kirito
 * @Date 2019/11/15 16:23
 */
public interface UserService {
    String queryUserByToken(String token);

    void logout(String token);
}
