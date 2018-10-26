package com.example.esdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.esdemo.dao")
public class EsdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsdemoApplication.class, args);
    }
}
