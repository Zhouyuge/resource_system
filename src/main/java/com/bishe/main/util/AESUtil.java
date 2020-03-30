package com.bishe.main.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

/**
 * @author Kirito
 * @Date 2019/11/15 10:05
 */
public class AESUtil {

    private static final byte[] KEY = new byte[]{-51, -45, -35, 79, 38, 93, -78, 83, -69, -54, -89, 84, 7, 112, 90, -95};

    public static String encrypt(String content){
        //构建
        AES aes = SecureUtil.aes(KEY);

        String encryptHex = aes.encryptHex(content);

        System.out.println(encryptHex);

        return encryptHex;
    }

    public static String decrypt(String encrypt){

        AES aes = SecureUtil.aes(KEY);

        String password = aes.decryptStr(encrypt, CharsetUtil.CHARSET_UTF_8);

        System.out.println(password);

        return password;
    }
}
