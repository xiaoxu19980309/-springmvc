package com.example.springbootdemo.tools;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

@Configuration
public class ResourceHandle implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        File fileDir = new File("classpath:src/main/resources/static/image/");
        registry.addResourceHandler("/file/**").addResourceLocations("file:E:\\大学\\web项目实践\\springboot-demo\\src\\main\\resources\\static\\image\\");
    }
}
