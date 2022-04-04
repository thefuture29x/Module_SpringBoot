package com.example.module_javaspringboot_day5_02.service;


import com.example.module_javaspringboot_day5_02.dto.CategoryDTO;
import com.example.module_javaspringboot_day5_02.dto.ProductDTO;

import java.util.ArrayList;

public interface ICategoryService {
    Iterable<CategoryDTO> findAll();
    ArrayList<ProductDTO> findListProductById(Integer id);
}
