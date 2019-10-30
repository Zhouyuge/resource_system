package com.bishe.mianshi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bishe.mianshi.dao")
public class MianshiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MianshiApplication.class, args);
    }

}
