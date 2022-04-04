package com.example.module_javaspringboot_day4.service;

import com.example.module_javaspringboot_day4.dto.CategoryDTO;
import com.example.module_javaspringboot_day4.dto.ProductDTO;

import java.util.ArrayList;

public interface ICategoryService {
    ArrayList<CategoryDTO> findAll();
    ArrayList<ProductDTO> findListProductById(Integer id);
}
