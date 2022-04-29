package com.example.module_javaspringboot_day22_01_practice.controller;

import com.example.module_javaspringboot_day22_01_practice.entities.ProductEntity;
import com.example.module_javaspringboot_day22_01_practice.entities.UserEntity;
import com.example.module_javaspringboot_day22_01_practice.repository.IUserRepository;
import com.example.module_javaspringboot_day22_01_practice.service.IDefaultSendMailService;
import com.example.module_javaspringboot_day22_01_practice.service.IProductService;
import com.example.module_javaspringboot_day22_01_practice.service.IUserService;
import org.aspectj.weaver.bcel.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    IDefaultSendMailService iDefaultSendMailService;
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    IUserService iUserService;
    @Autowired
    IProductService iProductService;


    @GetMapping("/login")
    public String getLoginForm() {
        return "login";
    }

    @PostMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("message", "Login again ???");
        return "login";
    }

    @GetMapping("/403")
    public String Page() {
        return "403";
    }

    @GetMapping("/bill-product")
    public String billProduct() {
        return "bill_product";
    }

    @GetMapping("/home")
    public String getHomePage(Model model, HttpSession session) {
        if (session.getAttribute("userLogin") != null) {
            model.addAttribute("userLogin", session.getAttribute("userLogin"));
        }
        int totalPage = (int) Math.ceil((double) iProductService.findAllProduct().size() / 4);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageable", PageRequest.of(1, 4));
        return "home";
    }

    @GetMapping("/data-pagination")
    public ResponseEntity<Page<ProductEntity>> getHomePagePagination(Pageable pageable) {
        return ResponseEntity.ok().body(iProductService.findAllProduct(PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize())));
    }

    @GetMapping("/forgot-password")
    public String getFogotPasswordForm() {
        return "forgot_password_form";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam(name = "email") String email, Model model) {
        UserEntity userEntity = iUserService.findByEmail(email);
        if (userEntity != null) {
            iDefaultSendMailService.sendMailResetPassword(email);
            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
        } else {
            model.addAttribute("message", "User Invalid");
        }
        return "forgot_password_form";
    }

    @GetMapping("/reset_password")
    public String getResetPasswordForm(Model model, @RequestParam("token") String token) {
        model.addAttribute("token", token);
        return "reset_password_form";
    }

    @PostMapping("/reset-password")
    public String resetPassword(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        String confirm_pass = request.getParameter("confirm-password");
        UserEntity userEntity = iUserService.findUserByToken(token);
        if (userEntity != null) {
            if (password.equals(confirm_pass)) {
                userEntity.setResetPassWordToken(null);
                userEntity.setPassword(bCryptPasswordEncoder.encode(password));
                iUserService.saveUser(userEntity);
                model.addAttribute("message", "Reset password successfull !");
            } else {
                model.addAttribute("message", "Reset password failed ! ");
            }

        }

        return "reset_password_form";
    }
}
