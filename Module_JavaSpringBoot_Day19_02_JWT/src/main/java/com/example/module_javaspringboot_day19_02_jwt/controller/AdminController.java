package com.example.module_javaspringboot_day19_02_jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/test")
@RolesAllowed(value = "ROLE_ADMIN")
public class AdminController {
    @GetMapping("/admin")
    public String getMentor(){
        return "Admin Content";
    }
}
