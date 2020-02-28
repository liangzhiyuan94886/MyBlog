package com.blog.liang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blog.liang.notes.dao")
public class LiangApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiangApplication.class, args);
    }

}
