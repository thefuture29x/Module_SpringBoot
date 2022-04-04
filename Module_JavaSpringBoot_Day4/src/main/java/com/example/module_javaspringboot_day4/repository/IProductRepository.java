package com.example.module_javaspringboot_day4.repository;

import com.example.module_javaspringboot_day4.dto.ProductDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface IProductRepository {
    ArrayList<ProductDTO> save(ProductDTO productDTO);
    ArrayList<ProductDTO> delete(Integer id);
    ArrayList<ProductDTO> findAll();
    ProductDTO findById(Integer id);
    ArrayList<ProductDTO> findByName(String search);

}
