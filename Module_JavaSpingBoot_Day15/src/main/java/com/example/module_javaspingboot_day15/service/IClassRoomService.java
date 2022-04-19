package com.example.module_javaspingboot_day15.service;

import com.example.module_javaspingboot_day15.entities.ClassRoomEntity;
import com.example.module_javaspingboot_day15.entities.TeacherEntity;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

import java.util.List;

public interface IClassRoomService {
    List<ClassRoomEntity> findAllClassRoom(Pageable pageable);

}
