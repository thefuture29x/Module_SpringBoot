package com.example.module_javaspringboot_day11.repository;

import com.example.module_javaspringboot_day11.entities.CategoryEntity;
import com.example.module_javaspringboot_day11.modal.CategoryModal;
import com.example.module_javaspringboot_day11.modal.ProductModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
