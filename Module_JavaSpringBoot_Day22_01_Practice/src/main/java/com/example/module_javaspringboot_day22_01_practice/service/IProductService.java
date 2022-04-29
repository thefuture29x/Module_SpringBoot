package com.example.module_javaspringboot_day22_01_practice.service;

import com.example.module_javaspringboot_day22_01_practice.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<ProductEntity> findAllProduct();
    ProductEntity findById(Long id);
    Page<ProductEntity> findAllProduct(Pageable pageable);
}
