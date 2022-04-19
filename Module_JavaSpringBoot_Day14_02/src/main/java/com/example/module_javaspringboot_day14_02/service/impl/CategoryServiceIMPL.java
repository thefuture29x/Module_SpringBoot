package com.example.module_javaspringboot_day14_02.service.impl;

import com.example.module_javaspringboot_day14_02.dto.CategoryDTO;
import com.example.module_javaspringboot_day14_02.dto.ProductDTO;
import com.example.module_javaspringboot_day14_02.entities.CategoryEntity;
import com.example.module_javaspringboot_day14_02.entities.ProductEntity;
import com.example.module_javaspringboot_day14_02.repository.ICategoryRepository;
import com.example.module_javaspringboot_day14_02.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceIMPL implements ICategoryService<CategoryDTO,Long> {
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Override
    public List<CategoryDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public boolean save(CategoryDTO categoryDTO) {
        return false;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public CategoryDTO findById(Long aLong) {
        CategoryEntity categoryEntity = iCategoryRepository.getById(aLong);
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setName(categoryEntity.getName());
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (ProductEntity enyities :
                categoryEntity.getListProduct()) {
            productDTOList.add(ProductEntity.toDTO(enyities));
        }
        categoryDTO.setListProductDTO(productDTOList);

        return categoryDTO;
    }
}
