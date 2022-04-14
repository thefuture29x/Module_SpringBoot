package com.example.module_javaspringboot_day11.controller;

import com.example.module_javaspringboot_day11.dto.CategoryDTO;
import com.example.module_javaspringboot_day11.dto.DetailCategoryDTO;
import com.example.module_javaspringboot_day11.dto.DetailImagesDTO;
import com.example.module_javaspringboot_day11.dto.ProductDTO;
import com.example.module_javaspringboot_day11.entities.DetailCategoryEntity;
import com.example.module_javaspringboot_day11.modal.*;
import com.example.module_javaspringboot_day11.service.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IProductService iProductService;
    @Autowired
    IDetailProductService iDetailProductService;
    @Autowired
    IDetailImagesService iDetailImagesService;
    @Autowired
    ICategoryService iCategoryService;
    @Autowired
    IDetailCategoryService iDetailCategoryService;


    @GetMapping("/get-all")
    public String getAllProduct(Model model,Pageable pageable){
        model.addAttribute("listCategory",getAllCategory());
        model.addAttribute("listProduct",getAllInformationProduct(pageable));
        return "home";
    }

    @GetMapping("/view-detail")
    public String viewDetail(@RequestParam(name = "id-product") int id_product,Model model){
        ProductModal modals = iProductService.findById((long)id_product);
        model.addAttribute("product",convertModalToDTO(modals));
        model.addAttribute("listCategory",getAllCategory());
        return "detail_product";
    }
    @GetMapping("/get-product-category")
    public String getProductWithCategory(Model model,@RequestParam(name = "id-category") int id_category){
        CategoryModal categoryModal = iCategoryService.findById((long)id_category);
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<ProductModal> productModalList = iProductService.findAll(categoryModal);
        for (ProductModal modals :
                productModalList) {
            ProductDTO productDTO = convertModalToDTO(modals);
            productDTOList.add(productDTO);
        }

        model.addAttribute("listProduct",productDTOList);
        model.addAttribute("listCategory",getAllCategory());
        return "home";

    }
    @GetMapping("/get-product-detailcategory")
    public String getProductWithDetailCategory(Model model,@RequestParam(name = "id-detail-category") int id_detail_category){
        DetailCategoryModal detailCategoryModal = iDetailCategoryService.findById((long) id_detail_category);
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<ProductModal> productModalList = iProductService.findAll(detailCategoryModal);
        for (ProductModal modals :
                productModalList) {
            ProductDTO productDTO = convertModalToDTO(modals);
            productDTOList.add(productDTO);
        }

        model.addAttribute("listProduct",productDTOList);
        model.addAttribute("listCategory",getAllCategory());
        return "home";

    }
    @GetMapping("/search-product")
    public String searchProduct(Model model,@RequestParam(name = "search-product") String search){
//        DetailCategoryModal detailCategoryModal = iDetailCategoryService.findById((long) id_detail_category);
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<ProductModal> productModalList = iProductService.search(search);
        for (ProductModal modals :
                productModalList) {
            ProductDTO productDTO = convertModalToDTO(modals);
            productDTOList.add(productDTO);
        }

        model.addAttribute("listProduct",productDTOList);
        model.addAttribute("listCategory",getAllCategory());
        return "home";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(Model model,HttpSession session,@RequestParam(name = "id-product") int id_product){
        List<Long> id_pr_cart = new ArrayList<>();
        if (session.getAttribute("cart") != null){
            id_pr_cart = (List<Long>) session.getAttribute("cart");
        }
        id_pr_cart.add((long)id_product);
        session.setAttribute("cart",id_pr_cart);
        return "redirect:get-all";
    }
    @GetMapping("/go-to-cart")
    public String gotocart(Model model,HttpSession session){
        List<Long> id_pr_cart = new ArrayList<>();
        if (session.getAttribute("cart") != null){
            id_pr_cart = (List<Long>) session.getAttribute("cart");
        }

        List<ProductDTO> productDTOList = new ArrayList<>();
        List<ProductModal> productModalList = iProductService.findCartProduct(id_pr_cart);
        for (ProductModal modals :
                productModalList) {
            ProductDTO productDTO = convertModalToDTO(modals);
            productDTOList.add(productDTO);
        }
        model.addAttribute("listCategory",getAllCategory());
        model.addAttribute("listProduct",productDTOList);
        return "cart_product";
    }
    @PostMapping("/delete-cart")
    public String deletePr(Model model,HttpSession session,@RequestParam(name = "id_product") int id_product){
        List<Long> id_pr_cart = new ArrayList<>();
        if (session.getAttribute("cart") != null){
            id_pr_cart = (List<Long>) session.getAttribute("cart");
        }

        for (int i = 0; i < id_pr_cart.size(); i++) {
            if (id_pr_cart.get(i) == (long) id_product) {
                id_pr_cart.remove(i);
            }
        }
        session.setAttribute("cart",id_pr_cart);
        return "redirect:go-to-cart";
    }




    public ProductDTO convertModalToDTO(ProductModal modal){
        ProductDTO productDTO = ProductModal.toDTO(modal);
        DetailProductModal detailProductModal = iDetailProductService.findById(modal.getDetailProductModalID());
        DetailCategoryModal detailCategory = iDetailCategoryService.findById(modal.getDetailCategoryModalID());
        CategoryModal categoryModal = iCategoryService.findById(modal.getCategoryModalID());

        List<DetailImagesDTO> detailImagesDTO = new ArrayList<>();
        for (Long id_detailImages :
                modal.getDetailImagesModalListID()) {
            detailImagesDTO.add(DetailImagesModal.toDTO(iDetailImagesService.findById(id_detailImages)));
        }

        productDTO.setDetailProductDTO(DetailProductModal.toDTO(detailProductModal));
        productDTO.setCategoryDTO(CategoryModal.toDTO(categoryModal));
        productDTO.setDetailCategoryDTO(DetailCategoryModal.toDTO(detailCategory));
        productDTO.setDetailImagesDTOList(detailImagesDTO);

        return productDTO;
    }

    public List<ProductDTO> getAllInformationProduct(Pageable pageable){
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<ProductModal> productModalList = iProductService.findAll(pageable);
        for (ProductModal modals :
                productModalList) {
            ProductDTO productDTO = convertModalToDTO(modals);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    public List<CategoryDTO> getAllCategory(){
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (CategoryModal modals : iCategoryService.findAll()) {
            CategoryDTO dto = CategoryModal.toDTO(modals);
            List<DetailCategoryDTO> dtoList = new ArrayList<>();
            for (Long id_detail : modals.getDetailCategoryModalListID()) {
                dtoList.add(DetailCategoryModal.toDTO(iDetailCategoryService.findById(id_detail)));
            }
            dto.setDetailCategoryDTOList(dtoList);

            categoryDTOList.add(dto);
        }

        return categoryDTOList;

    }

}
