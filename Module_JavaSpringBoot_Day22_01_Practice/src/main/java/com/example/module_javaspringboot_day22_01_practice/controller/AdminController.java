package com.example.module_javaspringboot_day22_01_practice.controller;

import com.example.module_javaspringboot_day22_01_practice.service.IProductService;
import com.example.module_javaspringboot_day22_01_practice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

@Controller
@RequestMapping("/admin")
@RolesAllowed(value = "ROLE_ADMIN")
public class AdminController {
    @Autowired
    IProductService iProductService;
    @Autowired
    IUserService iUserService;

    @GetMapping("/list-product")
    public String getListProduct(Model model){
        model.addAttribute("listProduct",iProductService.findAllProduct());
        return "admin_list_product";
    }
    @GetMapping("/list-user")
    public String getListUser(Model model){
        model.addAttribute("listUser",iUserService.findAllUser());
        return "admin_list_user";
    }
}
