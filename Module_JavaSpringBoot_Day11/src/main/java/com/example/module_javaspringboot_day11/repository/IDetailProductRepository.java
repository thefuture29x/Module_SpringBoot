package com.example.module_javaspringboot_day11.repository;

import com.example.module_javaspringboot_day11.entities.DetailProductEntity;
import com.example.module_javaspringboot_day11.entities.ProductEntity;
import com.example.module_javaspringboot_day11.modal.DetailProductModal;
import com.example.module_javaspringboot_day11.modal.ProductModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetailProductRepository extends JpaRepository<DetailProductEntity,Long> {
    void deleteByProductEntity(ProductEntity entity);
}
