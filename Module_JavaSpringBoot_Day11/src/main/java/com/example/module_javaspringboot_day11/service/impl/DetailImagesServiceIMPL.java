package com.example.module_javaspringboot_day11.service.impl;

import com.example.module_javaspringboot_day11.entities.DetailImagesEntity;
import com.example.module_javaspringboot_day11.modal.DetailImagesModal;
import com.example.module_javaspringboot_day11.repository.IDetailImagesRepository;
import com.example.module_javaspringboot_day11.repository.IProductRepository;
import com.example.module_javaspringboot_day11.service.IDetailImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailImagesServiceIMPL implements IDetailImagesService {
    @Autowired
    IDetailImagesRepository iDetailImagesRepository;
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public List<DetailImagesModal> findAll() {
        return null;
    }

    @Override
    public boolean save(DetailImagesModal detailImagesModal) {
        DetailImagesEntity entity = DetailImagesModal.toEntity(detailImagesModal);
        entity.setProductEntity(iProductRepository.getById(detailImagesModal.getProductModalID()));
        iDetailImagesRepository.save(entity);

        return true;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public DetailImagesModal findById(Long aLong) {
        return DetailImagesEntity.toModal(iDetailImagesRepository.getById(aLong));
    }
}
