package com.example.module_javaspringboot_day11.service.impl;

import com.example.module_javaspringboot_day11.entities.CategoryEntity;
import com.example.module_javaspringboot_day11.entities.DetailCategoryEntity;
import com.example.module_javaspringboot_day11.modal.CategoryModal;
import com.example.module_javaspringboot_day11.modal.DetailCategoryModal;
import com.example.module_javaspringboot_day11.repository.ICategoryRepository;
import com.example.module_javaspringboot_day11.repository.IDetailCategoryRepository;
import com.example.module_javaspringboot_day11.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceIMPL implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Autowired
    IDetailCategoryRepository iDetailCategoryRepository;

    @Override
    public List<CategoryModal> findAll() {
        List<CategoryModal> categoryModalList = new ArrayList<>();
        for (CategoryEntity entites : iCategoryRepository.findAll()) {
            CategoryModal modal = CategoryEntity.toModal(entites);
            List<Long> modals = new ArrayList<>();
            for (DetailCategoryEntity details:iDetailCategoryRepository.findByCategory(entites)) {
                modals.add(details.getId());
            }
            modal.setDetailCategoryModalListID(modals);
            categoryModalList.add(modal);
        }
        return categoryModalList;
    }

    @Override
    public boolean save(CategoryModal categoryModal) {
        return false;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public CategoryModal findById(Long aLong) {
        return CategoryEntity.toModal(iCategoryRepository.getById(aLong));
    }
}
