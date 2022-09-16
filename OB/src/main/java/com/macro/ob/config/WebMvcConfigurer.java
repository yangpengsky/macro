package com.macro.ob.config;

import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

/**
 * @author :yangpeng
 * @date : 2022/9/13
 */
//@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    /**
     * WebMvcConfigurer
     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。 需要重新指定静态资源
     */



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {


        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("swagger-ui.html", "doc.html").addResourceLocations(
                "classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);


    }

    @Value("${spring.jackson.date-format}")
    private String dateFormatPattern;

    @Value("${spring.jackson.time-zone}")
    private String timeZone;




    
}