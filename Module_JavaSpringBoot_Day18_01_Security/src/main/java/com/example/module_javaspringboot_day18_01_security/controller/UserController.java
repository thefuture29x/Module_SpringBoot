package com.example.module_javaspringboot_day18_01_security.controller;

import com.example.module_javaspringboot_day18_01_security.entities.PermissionEntity;
import com.example.module_javaspringboot_day18_01_security.entities.RoleEntity;
import com.example.module_javaspringboot_day18_01_security.entities.UserEntity;
import com.example.module_javaspringboot_day18_01_security.repository.IPermissionRepository;
import com.example.module_javaspringboot_day18_01_security.repository.IRoleRepository;
import com.example.module_javaspringboot_day18_01_security.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IRoleRepository roleRepository;
    @Autowired
    IPermissionRepository iPermissionRepository;

    @GetMapping(value = {"/","/home"})
    public String getHomePage(Model model,HttpSession session){
        if (session.getAttribute("user") != null){
            UserEntity user = (UserEntity) session.getAttribute("user");
            model.addAttribute("userObj",user);

        }else{
            model.addAttribute("userObj",new UserEntity());
        }
        return "home";
    }

    @GetMapping("/admin")
    public String getAuthenPage(){
        return "admin_page";
    }
    @GetMapping("/testajax")
    public String getAjaxPage(){
        return "testajax";
    }
    @GetMapping("/mentor")
    public String getMentor(Model model){
//        model.addAttribute("mentor",userRepository.getById(4L));
        return "mentor";
    }

    @GetMapping("/register")
    public String createUser(Model model){
        model.addAttribute("listRole",roleRepository.findAll());
        model.addAttribute("listPermission",iPermissionRepository.findAll());
        return "register";
    }

    @PostMapping("/register-user")
    public String register(@RequestParam("username") String name,
                           @RequestParam("password") String pass){
        UserEntity userEntity = userRepository.findByUsername(name);
        if (userEntity != null){
            return "redirect:/register";
        }else{
//            List<RoleEntity> roleEntities = new ArrayList<>();
//            roleEntities.add(roleRepository.getById(3L));
//            userRepository.save(new UserEntity(null,name,passwordEncoder.encode(pass),roleEntities));
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
    @GetMapping("/setdatabase")
    public String setPermission(){
//
//        List<PermissionEntity> perADMIN = new ArrayList<>();
//        perADMIN.add(iPermissionRepository.getById(1L));
//        perADMIN.add(iPermissionRepository.getById(2L));
//        perADMIN.add(iPermissionRepository.getById(3L));
//        perADMIN.add(iPermissionRepository.getById(4L));
//        perADMIN.add(iPermissionRepository.getById(5L));
//
//        List<PermissionEntity> perUSER = new ArrayList<>();
//        perUSER.add(iPermissionRepository.getById(1L));
//        perUSER.add(iPermissionRepository.getById(5L));
//
//        List<PermissionEntity> perMENTOR = new ArrayList<>();
//        perMENTOR.add(iPermissionRepository.getById(1L));
//        perMENTOR.add(iPermissionRepository.getById(2L));
//        perMENTOR.add(iPermissionRepository.getById(4L));
//        perMENTOR.add(iPermissionRepository.getById(5L));
//
//        RoleEntity roleADMIN = roleRepository.getById(1L);
//        roleADMIN.setPermissionEntityList(perADMIN);
//
//        RoleEntity roleUSER = roleRepository.getById(2L);
//        roleUSER.setPermissionEntityList(perUSER);
//
//        RoleEntity roleMENTOR = roleRepository.getById(3L);
//        roleMENTOR.setPermissionEntityList(perMENTOR);
//
//
//        roleRepository.save(roleADMIN);
//        roleRepository.save(roleUSER);
//        roleRepository.save(roleMENTOR);

        return "home";
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
