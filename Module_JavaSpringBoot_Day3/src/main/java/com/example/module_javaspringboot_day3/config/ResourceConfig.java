package com.example.module_javaspringboot_day3.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {
    @Value("${config.upload_folder}")
    String UPLOAD_FOLDER;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        Path cssPath = Paths.get("./static/css/");
        registry.addResourceHandler("/css/**").addResourceLocations("file:///Users/admin/Desktop/Module_JavaSpingBoot/Module_JavaSpringBoot_Day3/src/main/resources/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("js/");

        Path userUploadDirDir2 = Paths.get("./image-product");

        String userUpLoadPath2 = userUploadDirDir2.toFile().getAbsolutePath();
        registry.addResourceHandler("/image-product/**").addResourceLocations("file://" + userUpLoadPath2 + "/");

    }
}
