package com.hxsearch.arcsearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hxsearch.arcsearch.mapper")
public class ArcsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArcsearchApplication.class, args);
    }

}
