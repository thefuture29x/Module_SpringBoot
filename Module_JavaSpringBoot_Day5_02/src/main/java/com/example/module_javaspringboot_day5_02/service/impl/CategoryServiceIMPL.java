package com.example.module_javaspringboot_day5_02.service.impl;

import com.example.module_javaspringboot_day5_02.dto.CategoryDTO;
import com.example.module_javaspringboot_day5_02.dto.ProductDTO;
import com.example.module_javaspringboot_day5_02.repository.ICategoryRepository;
import com.example.module_javaspringboot_day5_02.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryServiceIMPL implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Override
    public Iterable<CategoryDTO> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public ArrayList<ProductDTO> findListProductById(Integer id) {
        return iCategoryRepository.findListProductByIdCategory(id);
    }
}
