package com.example.module_javaspringboot_day22_01_practice.controller;

import com.example.module_javaspringboot_day22_01_practice.config.AuthProvider;
import com.example.module_javaspringboot_day22_01_practice.dto.BillCheckoutDTO;
import com.example.module_javaspringboot_day22_01_practice.entities.CategoryEntity;
import com.example.module_javaspringboot_day22_01_practice.entities.ProductEntity;
import com.example.module_javaspringboot_day22_01_practice.entities.RoleEntity;
import com.example.module_javaspringboot_day22_01_practice.entities.UserEntity;
import com.example.module_javaspringboot_day22_01_practice.repository.ICategoryRepository;
import com.example.module_javaspringboot_day22_01_practice.repository.IProductRepository;
import com.example.module_javaspringboot_day22_01_practice.repository.IRoleRepository;
import com.example.module_javaspringboot_day22_01_practice.repository.IUserRepository;
import com.example.module_javaspringboot_day22_01_practice.service.IDefaultSendMailService;
import com.example.module_javaspringboot_day22_01_practice.service.IProductService;
import com.example.module_javaspringboot_day22_01_practice.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
@RolesAllowed(value = {"ROLE_ADMIN","ROLE_USER"})
public class UserController {
    @Autowired
    IRoleRepository iRoleRepository;
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    IProductService iProductService;
    @Autowired
    IDefaultSendMailService iDefaultSendMailService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    List<ProductEntity> listProduct = new ArrayList<>();

    @GetMapping("/add-to-cart")
    public String addProductToCart(HttpSession session, @RequestParam(name = "id-product") int id_product, Model model){
        ProductEntity productEntity = iProductService.findById((long) id_product);
        Long id = productEntity.getId();
        if (session.getAttribute("userLogin") == null){
            return "login";
        }else{
            model.addAttribute("userLogin",session.getAttribute("userLogin"));
        }

        if(session.getAttribute("listProductOnCart") == null){
            listProduct.add(productEntity);
            session.setAttribute("listProductOnCart",listProduct);
        }else{
            listProduct = (List<ProductEntity>) session.getAttribute("listProductOnCart");
            listProduct.add(productEntity);
            session.setAttribute("listProductOnCart", listProduct);
        }

        model.addAttribute("message","Add product to cart successfull !");

        model.addAttribute("listProduct",iProductService.findAllProduct());
        return "home";
    }
    @GetMapping("/go-to-cart")
    public String goToCart(HttpSession session, Model model){
        int total = 0;
        List<ProductEntity> list = (List<ProductEntity>) session.getAttribute("listProductOnCart");
        for (ProductEntity pro :
                list) {
            total += pro.getPrice();
        }
        UserEntity userEntity = (UserEntity) session.getAttribute("userLogin");
        model.addAttribute("userLogin",userEntity);
        model.addAttribute("total",total);
        model.addAttribute("cart",list);
        BillCheckoutDTO billCheckoutDTO = new BillCheckoutDTO();
        billCheckoutDTO.setTotal(total);
        billCheckoutDTO.setEmail(userEntity.getEmail());
        session.setAttribute("bill",billCheckoutDTO);
        session.setAttribute("listProduct",list);
        return "cart_product";
    }
    @GetMapping("/pay-cart")
    public String payCart(@RequestParam(name = "id") int id_user,HttpSession session){
        BillCheckoutDTO billCheckoutDTO = (BillCheckoutDTO) session.getAttribute("bill");
        List<ProductEntity> list = (List<ProductEntity>) session.getAttribute("listProduct");
        billCheckoutDTO.setStatus("Thanh toán thành công");
        billCheckoutDTO.setDate(LocalDate.now().toString());
        UserEntity userEntity = iUserRepository.getById((long) id_user);
        iDefaultSendMailService.sendMailToPayCart(userEntity.getEmail(),billCheckoutDTO,list);
        return "redirect:go-to-cart";
    }






    @GetMapping("/create-parent-data")
    public String createParentData(){
//        iCategoryRepository.save(new CategoryEntity(null,"Category 1",null));
//        iCategoryRepository.save(new CategoryEntity(null,"Category 2",null));
//        iCategoryRepository.save(new CategoryEntity(null,"Category 3",null));
//        iCategoryRepository.save(new CategoryEntity(null,"Category 4",null));
//
//        iRoleRepository.save(new RoleEntity(null,"ROLE_ADMIN",null));
//        iRoleRepository.save(new RoleEntity(null,"ROLE_USER",null));

        return "home";
    }
    @GetMapping("/create-child-data")
    public String createChildData(){
//        RoleEntity roleAdmin = iRoleRepository.getById(1L);
//        List<RoleEntity> listRoleAdmin = new ArrayList<>();
//        listRoleAdmin.add(roleAdmin);
//
//        RoleEntity roleUser = iRoleRepository.getById(2L);
//        List<RoleEntity> listRoleUser = new ArrayList<>();
//        listRoleUser.add(roleUser);
//
//        iUserRepository.save(new UserEntity(null,"admin","admin@gmail.com",bCryptPasswordEncoder.encode("123456"),true,null,AuthProvider.LOCAL,listRoleAdmin));
//        iUserRepository.save(new UserEntity(null,"user123","user123@gmail.com",bCryptPasswordEncoder.encode("123456"),true,null,AuthProvider.LOCAL,listRoleUser));
//
//
//        iProductRepository.save(new ProductEntity(null,"Product 01",1000,100,"Description 01",iCategoryRepository.getById(1L)));
//        iProductRepository.save(new ProductEntity(null,"Product 02",1000,100,"Description 02",iCategoryRepository.getById(1L)));
//        iProductRepository.save(new ProductEntity(null,"Product 03",1000,100,"Description 03",iCategoryRepository.getById(1L)));
//        iProductRepository.save(new ProductEntity(null,"Product 04",1000,100,"Description 04",iCategoryRepository.getById(2L)));
//        iProductRepository.save(new ProductEntity(null,"Product 05",1000,100,"Description 05",iCategoryRepository.getById(2L)));
//        iProductRepository.save(new ProductEntity(null,"Product 06",1000,100,"Description 06",iCategoryRepository.getById(3L)));
//        iProductRepository.save(new ProductEntity(null,"Product 07",1000,100,"Description 07",iCategoryRepository.getById(4L)));

        return "home";
    }

}
