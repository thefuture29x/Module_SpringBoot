package com.example.module_javaspringboot_day10_02.service.impl;

import com.example.module_javaspringboot_day10_02.modal.DetailCategoryModal;
import com.example.module_javaspringboot_day10_02.service.IDetailCategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailCategoryServiceIMPL implements IDetailCategoryService {
    @Override
    public Boolean save(DetailCategoryModal detailCategoryModal) {
        return null;
    }

    @Override
    public List<DetailCategoryModal> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public DetailCategoryModal findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long[] ids) {

    }
}
