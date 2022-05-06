package com.example.module_javaspringboot_finalproject.service.impl;

import com.example.module_javaspringboot_finalproject.dto.CategoryDTO;
import com.example.module_javaspringboot_finalproject.entities.CategoryEntity;
import com.example.module_javaspringboot_finalproject.repository.CategoryRepository;
import com.example.module_javaspringboot_finalproject.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<CategoryDTO> findAllCategory() {
        List<CategoryDTO> dtoList = new ArrayList<>();
        categoryRepository.findAll().stream().forEach(cate ->{
            CategoryDTO dto = CategoryEntity.toDTO(cate);
            dtoList.add(dto);
        });
        return dtoList;
    }
}
