package com.example.module_javaspringboot_day11.repository;

import com.example.module_javaspringboot_day11.entities.CategoryEntity;
import com.example.module_javaspringboot_day11.entities.DetailCategoryEntity;
import com.example.module_javaspringboot_day11.entities.ProductEntity;
import com.example.module_javaspringboot_day11.modal.ProductModal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findByCategoryEntity(CategoryEntity entity);
    List<ProductEntity> findByDetailCategoryEntity(DetailCategoryEntity entity);

    List<ProductEntity> findByName(String search);
    List<ProductEntity> searchByName(String search);
//    List<ProductEntity> findByNameOrDetailProductEntity_SizeOrDetailProductEntity_ColorOrDetailCategoryEntity_Name(String search);

}
