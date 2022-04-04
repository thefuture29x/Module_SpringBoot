package com.example.module_javaspringboot_day4.service.impl;

import com.example.module_javaspringboot_day4.dto.CategoryDTO;
import com.example.module_javaspringboot_day4.dto.ProductDTO;
import com.example.module_javaspringboot_day4.repository.ICategoryRepository;
import com.example.module_javaspringboot_day4.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryServiceIMPL implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Override
    public ArrayList<CategoryDTO> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public ArrayList<ProductDTO> findListProductById(Integer id) {
        return iCategoryRepository.findListProductById(id);
    }
}
