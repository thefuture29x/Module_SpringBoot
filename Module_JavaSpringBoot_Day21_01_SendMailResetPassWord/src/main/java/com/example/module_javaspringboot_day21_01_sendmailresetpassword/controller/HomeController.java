package com.example.module_javaspringboot_day21_01_sendmailresetpassword.controller;

import com.example.module_javaspringboot_day21_01_sendmailresetpassword.service.impl.DefaultSendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    DefaultSendMailService defaultSendMailService;
    @GetMapping("/forgot-password")
    public String forgotPassword(){
        String email = "teothiphong@gmail.com";
        defaultSendMailService.sendMailResetPassword(email);
        return "index";
    }
}
