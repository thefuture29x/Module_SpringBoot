package com.example.module_javaspringboot_day3.controller;

import com.example.module_javaspringboot_day3.dto.ProductDTO;
import com.example.module_javaspringboot_day3.repository.IProductRepository;
import com.example.module_javaspringboot_day3.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    IProductService iProductService;

    ArrayList<ProductDTO> dtoArrayList = new ArrayList<>();

    @GetMapping("/home")
    public String getHomePage(Model model, HttpSession session){
        model.addAttribute("listProduct",iProductService.findAll());
        return "home";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam(value = "id_pr") int id, HttpSession session,Model model){
        List<ProductDTO> cartProduct = (List<ProductDTO>) session.getAttribute("listProduct");
        session.setAttribute("listProduct",iProductService.findById(id));


//        Object[] arraysPR = new Object[10];
//        arraysPR = (Object[]) session.getAttribute("listProduct");
//        int obSize = arraysPR.length;
//        if (arraysPR == null){
//            arraysPR = new Object[1];
//        }
//        else {
//            Object[] arrays = new Object[obSize +1];
//            for (int i = 0; i < arraysPR.length; i++) {
//
//            }
//        }

//        arraysPR[1] = iProductService.findById(id);
//        session.setAttribute("cartProduct",arraysPR);
//        for (int i = 0; i < arraysPR.length; i++) {
//            System.out.println(arraysPR[i]);
//        }
        return "redirect:home";
    }
}
