package com.example.module_javaspingboot_day15.repository;

import com.example.module_javaspingboot_day15.entities.ClassRoomEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ClassRoomRepository extends ReactiveCrudRepository<ClassRoomEntity,Long> {
}
