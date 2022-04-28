package com.example.module_javaspringboot_day22_01_practice.service.impl;

import com.example.module_javaspringboot_day22_01_practice.entities.ProductEntity;
import com.example.module_javaspringboot_day22_01_practice.repository.IProductRepository;
import com.example.module_javaspringboot_day22_01_practice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public List<ProductEntity> findAllProduct() {
        return iProductRepository.findAll();
    }

    @Override
    public ProductEntity findById(Long id) {
        return iProductRepository.findById(id).get();
    }
}
