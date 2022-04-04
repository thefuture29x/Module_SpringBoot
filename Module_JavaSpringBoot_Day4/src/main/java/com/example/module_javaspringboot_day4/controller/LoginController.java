package com.example.module_javaspringboot_day4.controller;

import com.example.module_javaspringboot_day4.dto.UserDTO;
import com.example.module_javaspringboot_day4.service.ICategoryService;
import com.example.module_javaspringboot_day4.service.IProductService;
import com.example.module_javaspringboot_day4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    IUserService iUserService;
    @Autowired
    IProductService iProductService;
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/login")
    public String getFormLogin(Model model, UserDTO userDTO){
        model.addAttribute("userLogin",new UserDTO());
        return "login";
    }
    @GetMapping("/logout")
    public String logOut(Model model, HttpSession session){
        session.removeAttribute("UserLogin");
        model.addAttribute("userLogin",new UserDTO());
        return "login";
    }

    @PostMapping("/login")
    public String getInforFormLogin(Model model, UserDTO userDTO, HttpSession session){
        UserDTO userLogin = iUserService.checkInforUser(userDTO.getUsername(), userDTO.getPassword());

        if (userLogin != null){
            int id_user = iUserService.findByName(userLogin.getUsername()).getId();
            session.setAttribute("UserLogin",id_user);
            if (userLogin.getRole().equals("ROLE_ADMIN")){
                return "redirect:admin/list";
            }else {
                return "redirect:user/home";
            }
        }else{
            return "redirect:login";
        }

    }
    @PostMapping("/search")
    public String searchProduct(@RequestParam(value = "search") String search, Model model,HttpSession session){
        if (session.getAttribute("UserLogin") == null){
            model.addAttribute("userName","Anonymous");

        }else {
            int id_user = (int) session.getAttribute("UserLogin");
            model.addAttribute("userName",iUserService.findById(id_user).getUsername());
        }
        model.addAttribute("listProduct",iProductService.findByName(search));
        model.addAttribute("listCategory",iCategoryService.findAll());
        return "list_product";
    }
}
