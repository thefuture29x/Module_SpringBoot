package com.example.module_javaspringboot_finalproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path pathStatic = Paths.get("./src/main/resources/static");
        String fileStatic = pathStatic.toFile().getAbsolutePath();

        registry.addResourceHandler("/admin/product/**").addResourceLocations("file://" +fileStatic+"/admin/");
        registry.addResourceHandler("/admin/user/**").addResourceLocations("file://" +fileStatic+"/admin/");

        registry.addResourceHandler("/user/**").addResourceLocations("file://" +fileStatic+"/user/");


        registry.addResourceHandler("/css/**").addResourceLocations("file://" +fileStatic+"/user/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("file://" +fileStatic+"/user/js/");
//        registry.addResourceHandler("/images/**").addResourceLocations("file://" +fileStatic+"/user/images/");
//        registry.addResourceHandler("/avatars/**").addResourceLocations("file://" +fileStatic+"/user/avatars/");
        registry.addResourceHandler("/img/**").addResourceLocations("file://" +fileStatic+"/user/img/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("file://" +fileStatic+"/user/fonts/");

//        registry.addResourceHandler("/css/**").addResourceLocations("file://" +fileStatic+"/css/");
//        registry.addResourceHandler("/js/**").addResourceLocations("file://" +fileStatic+"/js/");
        registry.addResourceHandler("/images/**").addResourceLocations("file://" +fileStatic+"/images/");
        registry.addResourceHandler("/avatars/**").addResourceLocations("file://" +fileStatic+"/avatars/");
//        registry.addResourceHandler("/img/**").addResourceLocations("file://" +fileStatic+"/img/");
//        registry.addResourceHandler("/fonts/**").addResourceLocations("file://" +fileStatic+"/fonts/");
    }
}
