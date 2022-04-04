package com.example.module_javaspringboot_day4.controller;

import com.example.module_javaspringboot_day4.dto.ProductDTO;
import com.example.module_javaspringboot_day4.dto.UserDTO;
import com.example.module_javaspringboot_day4.repository.ICategoryRepository;
import com.example.module_javaspringboot_day4.repository.IProductRepository;
import com.example.module_javaspringboot_day4.service.ICategoryService;
import com.example.module_javaspringboot_day4.service.IProductService;
import com.example.module_javaspringboot_day4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    IUserService iUserService;
    @Autowired
    IProductService iProductService;
    @Autowired
    ICategoryService iCategoryService;

    ArrayList<ProductDTO> cartPr = new ArrayList<>();
    ProductDTO productDTO = new ProductDTO();

    @GetMapping("/home")
    public String getHomePage(Model model, HttpSession session){
        if (session.getAttribute("UserLogin") == null){
            model.addAttribute("userName","Anonymous");
        }else {
            int id_user = (int) session.getAttribute("UserLogin");
            model.addAttribute("userName",iUserService.findById(id_user).getUsername());
        }

        model.addAttribute("listProduct",iProductService.findAll());
        model.addAttribute("listCategory",iCategoryService.findAll());
        return "home";
    }

    @GetMapping("/ctg-product")
    public String getCategory(@RequestParam(value = "id-ctg") int id, Model model,HttpSession session){
        if (session.getAttribute("UserLogin") == null){
            model.addAttribute("userName","Anonymous");
        }else {
            int id_user = (int) session.getAttribute("UserLogin");
            model.addAttribute("userName",iUserService.findById(id_user).getUsername());
        }
        model.addAttribute("listProduct",iCategoryService.findListProductById(id));
        model.addAttribute("listCategory",iCategoryService.findAll());
        return "home";
    }
    @GetMapping("/cart")
    public String getCartProduct(HttpSession session,Model model){
        if (session.getAttribute("UserLogin") == null){
            model.addAttribute("userName","Anonymous");
        }else {
            int id_user = (int) session.getAttribute("UserLogin");
            model.addAttribute("userName",iUserService.findById(id_user).getUsername());
        }
        if (session.getAttribute("cartProduct") == null){
            model.addAttribute("listPrOnCart",new ArrayList<ProductDTO>());
        }else {
            ArrayList<ProductDTO> listPrInCart = (ArrayList<ProductDTO>) session.getAttribute("cartProduct");
            model.addAttribute("listPrOnCart",listPrInCart);
        }
        return "cart";
    }

    @PostMapping("/add-to-cart")
    public String addProductToCart(@RequestParam(value = "id_pr") int id, HttpSession session,Model model){
        if (session.getAttribute("UserLogin") == null){
            model.addAttribute("userLogin",new UserDTO());
            return "login";
        }

        productDTO = iProductService.findById(id);
//        productDTO.setCart_amount(1);
        boolean checkPr = false;
        int cart_amount = productDTO.getCart_amount();
        for (int i = 0; i < cartPr.size(); i++) {
            if (cartPr.get(i).getId() == id){
                productDTO.setCart_amount(cart_amount+=1);
                cartPr.set(i,productDTO);
                checkPr = true;
            }else {
//                cartPr.add(productDTO);
            }
        }
        if (checkPr == false){
            cartPr.add(productDTO);
        }
        session.setAttribute("cartProduct",cartPr);
        return "redirect:home";
    }
    @PostMapping("/delete-cart")
    public String deleteProduct(@RequestParam(value = "id_pr_delete") int id, Model model,HttpSession session){
        ArrayList<ProductDTO> listPrInCart = (ArrayList<ProductDTO>) session.getAttribute("cartProduct");
        for (int i = 0; i < listPrInCart.size(); i++) {
            if (listPrInCart.get(i).getId() == id){
                listPrInCart.remove(i);
            }
        }
        int id_user = (int) session.getAttribute("UserLogin");
        model.addAttribute("userName",iUserService.findById(id_user).getUsername());
        model.addAttribute("listPrOnCart",listPrInCart);
        return "cart";
    }


}
