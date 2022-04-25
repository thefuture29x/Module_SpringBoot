package com.example.module_javaspringboot_day19_02_jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/test")
@RolesAllowed(value = {"ROLE_ADMIN","ROLE_MENTOR"})
public class MentorController {
    @GetMapping("/mentor")
    public String getAdmin(){
        return "Mentor Content";
    }







}
