package com.example.module_javaspringboot_day11.repository;

import com.example.module_javaspringboot_day11.entities.CategoryEntity;
import com.example.module_javaspringboot_day11.entities.DetailCategoryEntity;
import com.example.module_javaspringboot_day11.modal.CategoryModal;
import com.example.module_javaspringboot_day11.modal.DetailCategoryModal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDetailCategoryRepository extends JpaRepository<DetailCategoryEntity,Long> {
    List<DetailCategoryEntity> findByCategory(CategoryEntity entity);
}
