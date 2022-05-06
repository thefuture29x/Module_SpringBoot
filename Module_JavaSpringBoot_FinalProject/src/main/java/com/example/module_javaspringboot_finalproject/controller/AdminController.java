package com.example.module_javaspringboot_finalproject.controller;

import com.example.module_javaspringboot_finalproject.dto.ProductDTO;
import com.example.module_javaspringboot_finalproject.dto.StatisticalDTO;
import com.example.module_javaspringboot_finalproject.service.ICategoryService;
import com.example.module_javaspringboot_finalproject.service.IProductService;
import com.example.module_javaspringboot_finalproject.service.ISoldService;
import com.example.module_javaspringboot_finalproject.service.IUserService;
import com.example.module_javaspringboot_finalproject.service.impl.SoldServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@RolesAllowed(value = "ROLE_ADMIN")
public class AdminController {
    @Autowired
    IProductService iProductService;
    @Autowired
    ICategoryService iCategoryService;
    @Autowired
    IUserService iUserService;
    @Autowired
    ISoldService iSoldService;


    @GetMapping("/home")
    public String getHomePage(HttpSession session, Model model){
        model.addAttribute("userLogin",session.getAttribute("userLogin"));
        return "admin_dashboard";
    }
    @GetMapping("/movement")
    public String getRecentMovementPage(HttpSession session, Model model){
        model.addAttribute("userLogin",session.getAttribute("userLogin"));
        return "admin_recent_movement";
    }
    @GetMapping("/product/list")
    public String getListProduct(Model model, Pageable pageable,HttpSession session){

        model.addAttribute("userLogin",session.getAttribute("userLogin"));
        model.addAttribute("listProduct",iProductService.findAllProduct(pageable));
        return "admin_list_product";
    }

    @GetMapping("/product/edit")
    public String getEditProductForm(@RequestParam(name = "id") int id, Model model,HttpSession session){
        model.addAttribute("userLogin",session.getAttribute("userLogin"));
        if (id == 0){
            model.addAttribute("productObj",new ProductDTO());
        }else{
            model.addAttribute("productObj",iProductService.findById((long) id));
        }
        model.addAttribute("listCategory",iCategoryService.findAllCategory());
        return "admin_edit_prduct_form";
    }

    @PostMapping("/product/delete")
    public String getDeleteProduct(@RequestParam(name = "id_product") int id, Model model){
        iProductService.delete((long) id);
//        model.addAttribute("message","Delete successfull !");
        return "redirect:list";
    }

    @PostMapping("/product/save")
    public String saveOrUpdateProduct(ProductDTO productDTO,
                                      @RequestParam(value = "image-product") MultipartFile file,
                                      Model model){
        if (file != null){
            productDTO.setImage(iProductService.uploadFile(file));
        }
        iProductService.saveOrUpdate(productDTO);
//        model.addAttribute("message","Save successfull !");
        return "redirect:list";
    }

    @GetMapping("/user/list")
    public String getListUser(Model model,HttpSession session){
        model.addAttribute("userLogin",session.getAttribute("userLogin"));
        model.addAttribute("listUser",iUserService.findAllUser());
        return "admin_list_user";
    }
    @PostMapping("/user/enabled")
    public String enabledUser(Model model,@RequestParam(name = "id_user") int id){
        iUserService.enabledUser((long) id);
        return "redirect:list";
    }
    @GetMapping("/statistical")
    public String getListStatistical(Model model,HttpSession session){
        model.addAttribute("userLogin",session.getAttribute("userLogin"));
        model.addAttribute("listStatistical", iSoldService.getListStatistic());
        return "admin_recent_movement";
    }

//    @GetMapping("/statistical")
//
//    public ResponseEntity<?> getStatistical(){
//        return ResponseEntity.ok().body(iSoldService.getListStatistic());
//    }

}
