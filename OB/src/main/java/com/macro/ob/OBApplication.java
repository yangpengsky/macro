package com.macro.ob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@MapperScan(basePackages = "com.macro.ob.mapper")
@SpringBootApplication
public class OBApplication {
    public static void main(String[] args) {


        System.out.println("yangpeng-----------------");
        SpringApplication.run(OBApplication.class,args);
    }
}
