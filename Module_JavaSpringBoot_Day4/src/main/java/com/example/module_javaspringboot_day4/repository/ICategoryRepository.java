package com.example.module_javaspringboot_day4.repository;

import com.example.module_javaspringboot_day4.dto.CategoryDTO;
import com.example.module_javaspringboot_day4.dto.ProductDTO;

import java.util.ArrayList;

public interface ICategoryRepository {
    ArrayList<CategoryDTO> save(CategoryDTO categoryDTO);
    ArrayList<CategoryDTO> delete(Integer id);
    ArrayList<CategoryDTO> findAll();
    ArrayList<ProductDTO> findListProductById(Integer id);
    CategoryDTO findById(Integer id);

}
