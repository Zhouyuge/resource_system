package com.bishe.main.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * @author Kirito
 * @Date 2019/11/13 11:14
 */
public class PicUtil {
    /**
     * 通过url下载图片
     *
     * @param filePath //储存的地址
     * @param imgUrl   //图片url
     * @return
     */
    public static String downImages(String filePath, String imgUrl) {
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 截取图片文件名
        String fileName = imgUrl.substring(imgUrl.lastIndexOf('/') + 1, imgUrl.length());

        try {
            //文件名里面可能有中文或者空格，所以这里需要处理。但空格又会被URLEncoder转义为加号
            String urlTail = URLEncoder.encode(fileName, "UTF-8");
            //因此要将加号转化为UTF-8的格式%20
            imgUrl = imgUrl.substring(0, imgUrl.lastIndexOf('/') + 1) + urlTail.replaceAll("\\+", "\\%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String rFileName = fileName;
        //写出的路径
        if (!fileName.contains(".jpg") && !fileName.contains("png")) {
            rFileName += fileName + ".png";
        }

        File file = new File(filePath + File.separator + rFileName);

        try {
            //获取图片URL
            URL url = new URL(imgUrl);
            //获得连接
            URLConnection connection = url.openConnection();
            //设置10秒的响应时间
            connection.setConnectTimeout(10 * 1000);
            //获得输入流
            InputStream in = connection.getInputStream();
            //获得输出流
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            //构建和缓冲区
            byte[] buf = new byte[1024];
            int size;
            //写入到文件
            while (-1 != (size = in.read(buf))) {
                out.write(buf, 0, size);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rFileName;
    }
}
