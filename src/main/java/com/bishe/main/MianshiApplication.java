package com.bishe.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.bishe.main.dao")
public class MianshiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MianshiApplication.class, args);
    }

}
