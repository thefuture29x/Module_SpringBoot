package com.example.module_javaspringboot_day3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

        @GetMapping("/home")
        public String home(){
            return "index";
        }
}
