package com.example.module_javaspingboot_day15.service.impl;

import com.example.module_javaspingboot_day15.dto.TeacherDTO;
import com.example.module_javaspingboot_day15.entities.TeacherEntity;
import com.example.module_javaspingboot_day15.repository.TeacherRepository;
import com.example.module_javaspingboot_day15.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TeacherServiceIMPL implements ITeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public Flux<TeacherEntity> findAllTeacher() {
        Flux<TeacherEntity> entityFlux = teacherRepository.findAllTeacherEntity();
        List<TeacherEntity> list = entityFlux.collectList().block();
        return null;
    }

    @Override
    public Mono<TeacherEntity> save(TeacherDTO teacherDTO) {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(teacherDTO.getId());
        teacherEntity.setName(teacherDTO.getName());
        teacherEntity.setId_classroom(teacherDTO.getId_classroom());
        return teacherRepository.save(teacherEntity);
    }
//    @Override
//    public Flux<TeacherEntity> findAllTeacher() {
//        Flux<TeacherEntity> entityFlux = teacherRepository.findAllTeacher();
//        return null;
//    }
}
