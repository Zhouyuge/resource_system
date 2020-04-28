package com.bishe.main.vo;

import com.bishe.main.entity.User;

/**
 * @author Kirito
 * @Date 2020/4/24 10:04
 */
public class UserVO extends User {
    String verifyCode;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
