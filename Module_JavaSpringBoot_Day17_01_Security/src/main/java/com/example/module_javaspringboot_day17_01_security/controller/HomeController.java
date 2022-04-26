package com.example.module_javaspringboot_day17_01_security.controller;

import com.example.module_javaspringboot_day17_01_security.entities.RoleEntity;
import com.example.module_javaspringboot_day17_01_security.entities.UserEntity;
import com.example.module_javaspringboot_day17_01_security.repository.RoleRepository;
import com.example.module_javaspringboot_day17_01_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @GetMapping(value = {"/","/home"})
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/admin")
    public String getAuthenPage(){
        return "admin_page";
    }

    @GetMapping("/add")
    public String createUser(){
        return "register";
    }
    @PostMapping("/register-user")
    public String register(@RequestParam("username") String name,
                           @RequestParam("password") String pass){
        UserEntity userEntity = userRepository.findByUsername(name);
        if (userEntity != null){
            return "redirect:/add";
        }else{
            List<RoleEntity> roleEntities = new ArrayList<>();
            roleEntities.add(roleRepository.getById(2L));
            userRepository.save(new UserEntity(null,name,passwordEncoder.encode(pass),roleEntities,true,true,0,null));
            return "redirect:/home";
        }
    }
    @GetMapping("/login-failed")
    public String loginFailed(){

        return "login";
    }


    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/403")
    public String get403Page(){
        return "403";
    }
    @GetMapping("/logout")
    public String getLogoutPage(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
        authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return "redirect:/home";
    }


}
