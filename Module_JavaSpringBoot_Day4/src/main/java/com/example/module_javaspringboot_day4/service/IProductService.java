package com.example.module_javaspringboot_day4.service;

import com.example.module_javaspringboot_day4.dto.ProductDTO;

import java.util.ArrayList;

public interface IProductService {
    ArrayList<ProductDTO> save(ProductDTO productDTO);
    ArrayList<ProductDTO> delete(Integer id);
    ArrayList<ProductDTO> findAll();
    ProductDTO findById(Integer id);
    ArrayList<ProductDTO> findByName(String search);
}
