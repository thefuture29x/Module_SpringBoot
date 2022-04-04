package com.example.module_javaspringboot_day3.controller;

import com.example.module_javaspringboot_day3.dto.ProductDTO;
import com.example.module_javaspringboot_day3.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @Value("${config.upload_folder}")
    String UPLOAD_FOLDER;

    @GetMapping("/list")
    public String getListPage(Model model){
        model.addAttribute("listProduct",iProductService.findAll());
        return "list_product";
    }
    @GetMapping("/insert")
    public String getInsertPage(Model model){
        model.addAttribute("product",new ProductDTO());
        return "edit_product";
    }

    @PostMapping("/edit")
    public String getEditPage(@RequestParam(value = "id_pr_edit") int id, Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "edit_product";
    }

    @PostMapping("/insert")
    public String insertProduct(Model model, ProductDTO productDTO, @RequestParam(value = "image-pr")MultipartFile file){
        productDTO.setImage(file.getOriginalFilename());
        model.addAttribute("listProduct",iProductService.save(productDTO));
//        uploadFile(file);
        uploadFile(file);
        return "list_product";
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam(value = "id_pr_delete") int id, Model model){
        model.addAttribute("listProduct",iProductService.delete(id));
        return "list_product";
    }

    public void uploadFile(MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();
        String uploadDir = "./image-product/";
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
