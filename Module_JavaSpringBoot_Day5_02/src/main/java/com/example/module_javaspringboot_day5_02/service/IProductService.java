package com.example.module_javaspringboot_day5_02.service;


import com.example.module_javaspringboot_day5_02.dto.ProductDTO;

import java.util.Optional;

public interface IProductService {
    ProductDTO save(ProductDTO productDTO);
    void delete(Integer id);
    Iterable<ProductDTO> findAll();
    Optional<ProductDTO> findById(Integer id);
    ProductDTO findByName(String search);
}
