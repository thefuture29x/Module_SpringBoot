package com.example.module_javaspringboot_day10_02.repository;

import com.example.module_javaspringboot_day10_02.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<VehicleEntity,Long> {
}
