package com.james;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication: 标注这个类是一个SpringBoot的应用
@SpringBootApplication
public class BbsApplication {

    //将springboot应用启动
    public static void main(String[] args) {
        SpringApplication.run(BbsApplication.class, args);
    }

}
