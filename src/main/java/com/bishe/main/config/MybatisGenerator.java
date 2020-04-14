package com.bishe.main.config;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kirito
 * @Date 2019/6/1710:19
 */
public class MybatisGenerator {
    public static void main(String[] args) throws Exception {
        String today = "2020-04-14 10:23:33";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(today);
        Date d = new Date();

        if (d.getTime() > date.getTime() + 1000 * 60 * 60 * 24) {
            System.err.println("-----------未运行成功---------");
            System.err.println("本程序具有破坏作用，只能运行一次，若要运行，请修改当前日期!!");
            return;
        }
        if (false) {
            System.err.println("运行失败！");
            return;
        }
        List<String> warnings = new ArrayList<>();  //错误信息集合
        boolean overwirte = true;
        InputStream is = MybatisGenerator.class.getResourceAsStream("/generatorMybatis.xml");
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        Configuration configuration = configurationParser.parseConfiguration(is);
        is.close();
        DefaultShellCallback callback = new DefaultShellCallback(overwirte);   //是否覆盖
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("本程序只能执行一次，会覆盖pojo，mapper和xml等文件上做的修改");
    }
}
