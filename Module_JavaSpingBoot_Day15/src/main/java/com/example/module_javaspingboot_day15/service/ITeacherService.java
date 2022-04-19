package com.example.module_javaspingboot_day15.service;

import com.example.module_javaspingboot_day15.dto.TeacherDTO;
import com.example.module_javaspingboot_day15.entities.TeacherEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITeacherService {
    Mono<TeacherEntity> save(TeacherDTO teacherDTO);
}
