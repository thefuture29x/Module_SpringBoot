package com.example.module_javaspringboot_finalproject.repository;

import com.example.module_javaspringboot_finalproject.entities.CategoryEntity;
import com.example.module_javaspringboot_finalproject.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    ProductEntity findByName(String name);
}
