package com.example.module_javaspringboot_day21_01_sendmailresetpassword.controller;

import com.example.module_javaspringboot_day21_01_sendmailresetpassword.entities.UserEntity;
import com.example.module_javaspringboot_day21_01_sendmailresetpassword.service.impl.DefaultSendMailService;
import com.example.module_javaspringboot_day21_01_sendmailresetpassword.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/save-user")
    public String saveUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(null);
        userEntity.setUsername("haiphong123");
        userEntity.setPassword(bCryptPasswordEncoder.encode("123456"));
        userEntity.setEmail("chiphongteo1123@gmail.com");
        userEntity.setEnabled(true);
        userEntity.setResetPassWordToken(null);
        userService.saveUser(userEntity);
        return "index";
    }

    @GetMapping("/login-form")
    public String getLoginForm(){
        return "login_form";
    }
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

}
