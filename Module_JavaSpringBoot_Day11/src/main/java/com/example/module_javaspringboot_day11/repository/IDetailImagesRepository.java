package com.example.module_javaspringboot_day11.repository;

import com.example.module_javaspringboot_day11.entities.DetailImagesEntity;
import com.example.module_javaspringboot_day11.entities.ProductEntity;
import com.example.module_javaspringboot_day11.modal.DetailImagesModal;
import com.example.module_javaspringboot_day11.modal.ProductModal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDetailImagesRepository extends JpaRepository<DetailImagesEntity,Long> {
    List<DetailImagesEntity> findByProductEntity(ProductEntity entity);
    void deleteByProductEntity(ProductEntity entity);
}
