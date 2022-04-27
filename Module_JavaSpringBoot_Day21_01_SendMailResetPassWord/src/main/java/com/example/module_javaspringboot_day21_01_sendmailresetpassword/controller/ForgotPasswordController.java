package com.example.module_javaspringboot_day21_01_sendmailresetpassword.controller;

import com.example.module_javaspringboot_day21_01_sendmailresetpassword.entities.UserEntity;
import com.example.module_javaspringboot_day21_01_sendmailresetpassword.repository.IUserRepository;
import com.example.module_javaspringboot_day21_01_sendmailresetpassword.service.IUserService;
import com.example.module_javaspringboot_day21_01_sendmailresetpassword.service.impl.DefaultSendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ForgotPasswordController {
    @Autowired
    DefaultSendMailService defaultSendMailService;
    @Autowired
    IUserService iUserService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/forgot-password")
    public String getForgotPasswordForm(){
        return "forgot_password_form";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam(name = "email") String email,Model model){
        defaultSendMailService.sendMailResetPassword(email);
        model.addAttribute("message","We have sent a reset password link to your email. Please check.");
        return "forgot_password_form";
    }
    @GetMapping("/reset_password")
    public String getResetPasswordForm(Model model, @Param("token") String token){
        model.addAttribute("token",token);
        return "reset_password_form";
    }
    @PostMapping("/reset_password")
    public String resetPassword(HttpServletRequest request){
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        String confirm_pass = request.getParameter("confirm-pass");
        UserEntity userEntity = iUserService.findUserByToken(token);
        if (userEntity != null){
            if (password.equals(confirm_pass)){
                userEntity.setResetPassWordToken(null);
                userEntity.setPassword(bCryptPasswordEncoder.encode(password));
                iUserService.saveUser(userEntity);
            }else {

            }

        }
        return "login_form";
    }

}
