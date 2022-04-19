package com.example.module_javaspringboot_day14_02.controller;

import com.example.module_javaspringboot_day14_02.dto.CategoryDTO;
import com.example.module_javaspringboot_day14_02.dto.ProductDTO;
import com.example.module_javaspringboot_day14_02.service.ICategoryService;
import com.example.module_javaspringboot_day14_02.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/get-category")
    public Response<CategoryDTO> getProductWithCategory() {
        CategoryDTO categoryDTO = (CategoryDTO) iCategoryService.findById(1L);
        return Response.ofSucceeded(categoryDTO);
    }
}
