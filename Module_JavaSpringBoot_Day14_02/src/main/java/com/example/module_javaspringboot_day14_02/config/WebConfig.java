package com.example.module_javaspringboot_day14_02.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path userUploadDirDir = Paths.get("./src/main/resources/static/images");

        String userUpLoadPath = userUploadDirDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/images/**").addResourceLocations("file://" + userUpLoadPath + "/");
    }
}
