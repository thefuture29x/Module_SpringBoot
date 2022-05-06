package com.example.module_javaspringboot_finalproject.api;

import com.example.module_javaspringboot_finalproject.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductAPI {
    @Autowired
    IProductService iProductService;

    @GetMapping("/list")
    public ResponseEntity<?> getList(Pageable pageable){
        return ResponseEntity.ok().body(iProductService.findAllProduct(pageable));
    }
    @GetMapping("/get-by-id")
    public ResponseEntity<?> getProductById(Long id_product){
        return ResponseEntity.ok().body(iProductService.findById(id_product));
    }



}
