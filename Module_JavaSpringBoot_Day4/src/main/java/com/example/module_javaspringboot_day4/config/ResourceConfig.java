package com.example.module_javaspringboot_day4.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/fragment/**").addResourceLocations("templates/fragment/");
        registry.addResourceHandler("/css/**").addResourceLocations("file:///Users/admin/Desktop/Module_JavaSpingBoot/Module_JavaSpringBoot_Day3/src/main/resources/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("js/");

        Path userUploadDirDir = Paths.get("./image-product");

        String userUpLoadPath = userUploadDirDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/image-product/**").addResourceLocations("file://" + userUpLoadPath + "/");
    }
}
