package com.example.module_javaspringboot_day3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@SpringBootApplication
@EnableJdbcHttpSession
public class ModuleJavaSpringBootDay3Application {

    public static void main(String[] args) {
        SpringApplication.run(ModuleJavaSpringBootDay3Application.class, args);
    }

}
