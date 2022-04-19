package com.example.module_javaspringboot_day14_02.repository;

import com.example.module_javaspringboot_day14_02.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
