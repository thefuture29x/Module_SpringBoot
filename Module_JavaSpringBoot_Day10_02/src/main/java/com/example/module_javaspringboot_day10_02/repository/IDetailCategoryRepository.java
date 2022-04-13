package com.example.module_javaspringboot_day10_02.repository;

import com.example.module_javaspringboot_day10_02.entities.CategoryVehicleEntity;
import com.example.module_javaspringboot_day10_02.entities.DetailCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDetailCategoryRepository extends JpaRepository<DetailCategoryEntity,Long> {
    List<DetailCategoryEntity> findByCategoryVehicleEntity(CategoryVehicleEntity categoryVehicle);
}
