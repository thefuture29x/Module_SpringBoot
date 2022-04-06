//package com.example.themehaiphong.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@Configuration
//public class ResourceConfig implements WebMvcConfigurer {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/fragment/**").addResourceLocations("templates/fragment/");
//        registry.addResourceHandler("/js/**").addResourceLocations("file:///Users/admin/Desktop/Module_JavaSpingBoot/Module_JavaSpringBoot_Day5_02/src/main/resources/static/js/");
//        registry.addResourceHandler("/css/**").addResourceLocations("file:///Users/admin/Desktop/Module_JavaSpingBoot/Module_JavaSpringBoot_Day5_02/src/main/resources/static/css/");
//        Path userUploadDirDir = Paths.get("./src/main/resources/static/image-product");
//
//        String userUpLoadPath = userUploadDirDir.toFile().getAbsolutePath();
//        registry.addResourceHandler("/image-product/**").addResourceLocations("file://" + userUpLoadPath + "/");
//    }
//}
