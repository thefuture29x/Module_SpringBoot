package com.example.module_javaspringboot_day22_01_practice.repository;

import com.example.module_javaspringboot_day22_01_practice.entities.ProductEntity;
import com.example.module_javaspringboot_day22_01_practice.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity,Long> {
}
