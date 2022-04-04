package com.example.module_javaspringboot_day3.service;

import com.example.module_javaspringboot_day3.dto.ProductDTO;

import java.util.ArrayList;

public interface IProductService {
    ArrayList<ProductDTO> save(ProductDTO productDTO);
    ArrayList<ProductDTO> delete(Integer id);
    ArrayList<ProductDTO> findAll();
    ProductDTO findById(Integer id);
}
