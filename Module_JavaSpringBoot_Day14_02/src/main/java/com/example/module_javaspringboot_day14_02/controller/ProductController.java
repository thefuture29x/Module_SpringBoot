package com.example.module_javaspringboot_day14_02.controller;

import com.example.module_javaspringboot_day14_02.dto.ProductDTO;
import com.example.module_javaspringboot_day14_02.repository.IProductRepository;
import com.example.module_javaspringboot_day14_02.service.IProductService;
import com.example.module_javaspringboot_day14_02.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @Autowired
    IProductRepository iProductRepository;

    @GetMapping("/get-all")
    public Response<List<ProductDTO>> getAll(Pageable pageable) {
        List<ProductDTO> list = iProductService.findAll(pageable);

        return Response.ofSucceeded(list);
    }

    @PostMapping("/save")
    public Response<Boolean> save(@RequestBody ProductDTO productDTO){
        return Response.ofSucceeded(iProductService.save(productDTO));
    }

    @DeleteMapping("/delete")
    public Response<Boolean> delete(@RequestBody Long id){
        iProductRepository.deleteById(id);
        return Response.ofSucceeded(true);
    }

    @RequestMapping(path = "/save-with-image",method = RequestMethod.POST,consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = { "application/xml", "application/json" })
    public Response<Boolean> saveWithImage(@ModelAttribute ProductDTO productDTO) {
        ProductDTO newProduct  = productDTO;
        newProduct.setImage(uploadFile(productDTO.getFile()));

        return Response.ofSucceeded(iProductService.save(newProduct));
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
        return fileName;
    }


}
