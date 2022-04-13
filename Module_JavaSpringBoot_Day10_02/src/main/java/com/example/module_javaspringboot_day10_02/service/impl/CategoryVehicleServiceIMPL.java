package com.example.module_javaspringboot_day10_02.service.impl;

import com.example.module_javaspringboot_day10_02.entities.CategoryVehicleEntity;
import com.example.module_javaspringboot_day10_02.entities.DetailCategoryEntity;
import com.example.module_javaspringboot_day10_02.modal.CategoryVehicleModal;
import com.example.module_javaspringboot_day10_02.modal.DetailCategoryModal;
import com.example.module_javaspringboot_day10_02.repository.ICategoryRepository;
import com.example.module_javaspringboot_day10_02.repository.IDetailCategoryRepository;
import com.example.module_javaspringboot_day10_02.service.ICategoryVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryVehicleServiceIMPL implements ICategoryVehicleService {
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Autowired
    IDetailCategoryRepository iDetailCategoryRepository;

    @Override
    public Boolean save(CategoryVehicleModal categoryVehicleModal) {
        return null;
    }

    @Override
    public List<CategoryVehicleModal> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CategoryVehicleModal findById(Long id) {
        Optional<CategoryVehicleEntity> entity = iCategoryRepository.findById(id);
        CategoryVehicleEntity entity1 = iCategoryRepository.getById(id);
        CategoryVehicleModal modal = CategoryVehicleEntity.toModal(iCategoryRepository.getById(id));
        CategoryVehicleEntity categoryVehicle = CategoryVehicleModal.toEntity(modal);
        List<DetailCategoryModal> detailCategoryModals = new ArrayList<>();
        for (DetailCategoryEntity details: iDetailCategoryRepository.findByCategoryVehicleEntity(categoryVehicle)) {
            detailCategoryModals.add(DetailCategoryEntity.toModal(details));
        }
        modal.setDetailCategoryModalList(detailCategoryModals);
        return modal;
    }

    @Override
    public void delete(Long[] ids) {

    }
}
