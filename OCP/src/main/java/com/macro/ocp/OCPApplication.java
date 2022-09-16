package com.macro.ocp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.oas.annotations.EnableOpenApi;


@EnableCaching
@MapperScan(basePackages = "com.macro.ocp.mapper")
@SpringBootApplication
@EnableOpenApi
public class OCPApplication {
    public static void main(String[] args) {
        SpringApplication.run(OCPApplication.class,args);
    }
}
