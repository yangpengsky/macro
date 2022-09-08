package com.macro.ob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = "com.macro.ob.mapper")
@SpringBootApplication
public class OBApplication {
    public static void main(String[] args) {
        SpringApplication.run(OBApplication.class,args);
    }
}
