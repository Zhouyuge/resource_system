package com.bishe.main;

import com.bishe.main.util.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @author Kirito
 * @Date 2019/10/30 16:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileTest {
    /**
     * 测试获取面试文件夹下的所有文件
     */
    @Test
    public void fileTest() {
        File file = new File("D://面试题//Java面试宝典导读//");
        //如果这个路径是文件夹
        if (file.isDirectory()) {
            //获取路径下的文件夹
            File[] files = file.listFiles();
            for (File f : files) {
                for (File f1 : f.listFiles()) {
                    String s = FileUtils.readFileContent(f1);
                    System.out.println(s);
                }
            }
        }
    }
}
