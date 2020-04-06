package com.bishe.main.util;


import com.bishe.main.entity.User;

/**
 * @author Kirito
 * @Date 2019/11/14 15:29
 */
public class LoginUtil {
    public static boolean Validatelogon(User user, String password){
        String userPassword = AESUtil.decrypt(user.getUserPassword());

        if (userPassword.equals(password)) {
            return true;
        }
        return false;
    }
}
