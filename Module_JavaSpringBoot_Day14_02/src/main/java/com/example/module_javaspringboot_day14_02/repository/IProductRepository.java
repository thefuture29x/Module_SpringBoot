package com.example.module_javaspringboot_day14_02.repository;

import com.example.module_javaspringboot_day14_02.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity,Long> {
}
