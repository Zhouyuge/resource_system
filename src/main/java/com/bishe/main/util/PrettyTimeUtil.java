package com.bishe.main.util;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Kirito
 * @Date 2020/2/28 13:06
 */
public class PrettyTimeUtil {
    public static String getPrettyTime(Date date) {
        Locale locale = Locale.CHINESE;
        Locale.setDefault(Locale.CHINESE);
        // 获取当前时间
        Date currentDate = new Date();
        // 解析时间
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
            String parseStr = format.format(currentDate);
            PrettyTime prettyTime = new PrettyTime(format.parse(parseStr));
            String s = prettyTime.format(date);
            return s;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
