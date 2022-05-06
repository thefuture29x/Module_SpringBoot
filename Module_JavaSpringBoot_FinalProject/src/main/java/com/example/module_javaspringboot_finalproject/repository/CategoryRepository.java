package com.example.module_javaspringboot_finalproject.repository;

import com.example.module_javaspringboot_finalproject.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    CategoryEntity findByName(String name);
}
