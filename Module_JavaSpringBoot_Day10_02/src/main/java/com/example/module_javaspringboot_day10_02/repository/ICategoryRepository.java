package com.example.module_javaspringboot_day10_02.repository;

import com.example.module_javaspringboot_day10_02.entities.CategoryVehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryVehicleEntity,Long> {
}
