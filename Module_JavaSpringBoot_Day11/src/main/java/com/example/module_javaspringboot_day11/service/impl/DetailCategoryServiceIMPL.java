package com.example.module_javaspringboot_day11.service.impl;

import com.example.module_javaspringboot_day11.entities.DetailCategoryEntity;
import com.example.module_javaspringboot_day11.modal.DetailCategoryModal;
import com.example.module_javaspringboot_day11.repository.ICategoryRepository;
import com.example.module_javaspringboot_day11.repository.IDetailCategoryRepository;
import com.example.module_javaspringboot_day11.service.IDetailCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DetailCategoryServiceIMPL implements IDetailCategoryService {
    @Autowired
    IDetailCategoryRepository iDetailCategoryRepository;
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Override
    public List<DetailCategoryModal> findAll() {
        List<DetailCategoryModal> detailCategoryModalList = new ArrayList<>();
        for (DetailCategoryEntity entites :
                iDetailCategoryRepository.findAll()) {
            DetailCategoryModal modal = DetailCategoryEntity.toModal(entites);
            modal.setCategoryID(entites.getCategory().getId());
            detailCategoryModalList.add(modal);
        }
        return detailCategoryModalList;
    }

    @Override
    public boolean save(DetailCategoryModal detailCategoryModal) {
        DetailCategoryEntity entity = DetailCategoryModal.toEntity(detailCategoryModal);
        entity.setCategory(iCategoryRepository.getById(detailCategoryModal.getCategoryID()));
        return false;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public DetailCategoryModal findById(Long aLong) {

        return DetailCategoryEntity.toModal(iDetailCategoryRepository.findById(aLong).orElse(null));
    }
}
