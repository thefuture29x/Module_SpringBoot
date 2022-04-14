package com.example.module_javaspringboot_day11.controller;

import com.example.module_javaspringboot_day11.dto.*;
import com.example.module_javaspringboot_day11.modal.*;
import com.example.module_javaspringboot_day11.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
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
    public String getAllProduct(Model model, Pageable pageable){
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<ProductModal> productModalList = iProductService.findAll(pageable);
        for (ProductModal modals :
                productModalList) {
            ProductDTO productDTO = convertModalToDTO(modals);
            productDTOList.add(productDTO);
        }

        model.addAttribute("listProduct",productDTOList);
        return "list_product";

    }
    @GetMapping("/get-category")
    public String getAllCategory(Model model){
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
        model.addAttribute("listCategory",categoryDTOList);
        return "header";
    }

    @PostMapping("/edit-product")
    public String saveOrUpdate(Model model, @RequestParam(name = "id_product") int id_product){
        if (id_product == 0){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setDetailProductDTO(null);
            model.addAttribute("product",new ProductDTO());
        }else {
            ProductModal modals = iProductService.findById((long)id_product);
            model.addAttribute("product",convertModalToDTO(modals));
        }
        return "edit_product";
    }

    @PostMapping("/save-product")
    public String insertProduct(Model model, ProductDTO productDTO, @RequestParam(name = "image-pr")MultipartFile file){
        ProductModal productModal = ProductDTO.toModal(productDTO);

        DetailProductModal detailProductModal = DetailProductDTO.toModal(productDTO.getDetailProductDTO());
        detailProductModal.setProductModalID(productModal.getId());
        Long iddetail = iDetailProductService.save2(detailProductModal);

//        productModal.setDetailProductModalID(productDTO.getDetailProductDTO().getId());
        productModal.setDetailProductModalID(iddetail);
        productModal.setCategoryModalID(productDTO.getCategoryDTO().getId());
        productModal.setDetailCategoryModalID(productDTO.getDetailCategoryDTO().getId());

        ProductModal modal = iProductService.save2(productModal);
        ProductDTO dtos = ProductModal.toDTO(modal);
        DetailImagesDTO dto = new DetailImagesDTO();
        if (!file.isEmpty()){
            dto.setId(null);
            dto.setImage(uploadFile(file));
            DetailImagesModal detailImagesModal = DetailImagesDTO.toModal(dto);
            detailImagesModal.setProductModalID(dtos.getId());
            iDetailImagesService.save(detailImagesModal);
        }
        return "redirect:get-all";
    }
    @PostMapping("/delete-product")
    public String deleteProduct(Model model,@RequestParam(name = "id_product") int id_product){
        if (id_product != 0){
            iProductService.delete((long)id_product);
        }
        return "redirect:get-all";
    }

    public String uploadFile(MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();
        String replaceFileName = fileName.replaceAll("\\s+", "");
        String uploadDir = "./src/main/resources/static/images/";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(replaceFileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return replaceFileName;
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

    public List<ProductDTO> getAllInformationProduct(){
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<ProductModal> productModalList = iProductService.findAll();
        for (ProductModal modals :
                productModalList) {
            ProductDTO productDTO = convertModalToDTO(modals);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }


}
