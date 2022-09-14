package com.macro.ob.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author :yangpeng
 * @date : 2022/9/13
 */


@Configuration
public class swaggerConfig {

    @Bean
    Docket docket(){
        // 设置 swagger的版本
        return new Docket(DocumentationType.OAS_30)
                // 选择生成接口文档
                .select()
                // 包所在的路径
                .apis(RequestHandlerSelectors.basePackage("com.macro.ob.controller"))
                // 当前包下所有接口都生成
                .paths(PathSelectors.any())
                .build()
                // 接口文档初始化，也就是设置接口文档的详细信息，
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("运营商接口文档")
                                // 联系人
                                //.contact(new Contact("crc","https://blog.csdn.net/cenrc?spm=1001.2101.3001.5343","2516313840@qq.com"))
                                .version("v1.0")
                                .title("API 测试文档")
                                .license("Apache 2.0")
                                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                                .build()
                );
    }
}
