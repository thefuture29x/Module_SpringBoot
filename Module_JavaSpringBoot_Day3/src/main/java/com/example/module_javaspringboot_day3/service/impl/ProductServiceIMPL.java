package com.example.module_javaspringboot_day3.service.impl;

import com.example.module_javaspringboot_day3.dto.ProductDTO;
import com.example.module_javaspringboot_day3.repository.IProductRepository;
import com.example.module_javaspringboot_day3.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServiceIMPL implements IProductService {
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public ArrayList<ProductDTO> save(ProductDTO productDTO) {
        return iProductRepository.save(productDTO);
    }

    @Override
    public ArrayList<ProductDTO> delete(Integer id) {
        return iProductRepository.delete(id);
    }

    @Override
    public ArrayList<ProductDTO> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public ProductDTO findById(Integer id) {
        return iProductRepository.findById(id);
    }
}
