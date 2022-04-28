package com.example.module_javaspringboot_day22_01_practice.service;

import com.example.module_javaspringboot_day22_01_practice.entities.ProductEntity;

import java.util.List;

public interface IProductService {
    List<ProductEntity> findAllProduct();
    ProductEntity findById(Long id);
}
