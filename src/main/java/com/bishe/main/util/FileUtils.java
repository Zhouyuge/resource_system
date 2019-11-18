package com.bishe.main.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Kirito
 * @Date 2019/10/30 16:19
 * 文件工具类
 */
public class FileUtils {
    /**
     * 读取文本文件内容
     *
     * @param file
     * @return
     */
    public static String readFileContent(File file) {
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {  //读取到的数据不为空
                sbf.append(tempStr);
            }
            reader.close();     //关闭输出流
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("----------->输出字节流关闭失败");
                }
            }
        }
        return sbf.toString();
    }

}
