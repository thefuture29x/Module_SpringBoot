package com.example.module_javaspringboot_finalproject.service;

import com.example.module_javaspringboot_finalproject.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> findAllCategory();
}
