package com.example.module_javaspringboot_day11.service.impl;

import com.example.module_javaspringboot_day11.entities.DetailProductEntity;
import com.example.module_javaspringboot_day11.modal.DetailProductModal;
import com.example.module_javaspringboot_day11.repository.IDetailProductRepository;
import com.example.module_javaspringboot_day11.repository.IProductRepository;
import com.example.module_javaspringboot_day11.service.IDetailProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailProductServiceIMPL implements IDetailProductService {
    @Autowired
    IDetailProductRepository iDetailProductRepository;
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public List<DetailProductModal> findAll() {
        return null;
    }

    @Override
    public boolean save(DetailProductModal detailProductModal) {
        DetailProductEntity entity = DetailProductModal.toEntity(detailProductModal);
        entity.setProductEntity(iProductRepository.getById(detailProductModal.getProductModalID()));

        return false;
    }
    @Override
    public Long save2(DetailProductModal detailProductModal) {
        DetailProductEntity entity = DetailProductModal.toEntity(detailProductModal);
        if (detailProductModal.getProductModalID() != null){
            entity.setProductEntity(iProductRepository.getById(detailProductModal.getProductModalID()));
        }

        return DetailProductEntity.toModal(iDetailProductRepository.save(entity)).getId();
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public DetailProductModal findById(Long aLong) {
        return DetailProductEntity.toModal(iDetailProductRepository.getById(aLong));
    }
}
