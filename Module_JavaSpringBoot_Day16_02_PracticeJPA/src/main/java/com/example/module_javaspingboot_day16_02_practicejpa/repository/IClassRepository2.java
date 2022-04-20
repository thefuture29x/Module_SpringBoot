package com.example.module_javaspingboot_day16_02_practicejpa.repository;

import com.example.module_javaspingboot_day16_02_practicejpa.entities.ClassRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRepository2 extends JpaRepository<ClassRoomEntity,Long> {
}
