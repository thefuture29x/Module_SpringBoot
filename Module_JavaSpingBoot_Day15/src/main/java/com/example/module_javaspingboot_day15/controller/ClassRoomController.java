package com.example.module_javaspingboot_day15.controller;

import com.example.module_javaspingboot_day15.entities.ClassRoomEntity;
import com.example.module_javaspingboot_day15.entities.TeacherEntity;
import com.example.module_javaspingboot_day15.repository.ClassRoomRepository;
import com.example.module_javaspingboot_day15.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ClassRoomController {
    @Autowired
    ClassRoomRepository classRoomRepository;

    @GetMapping("/get-classroom")
    public Flux<ClassRoomEntity> getAll(){
        return classRoomRepository.findAll();
    }

    @GetMapping("/test-get-classroom")
    public Flux<ClassRoomEntity> testGetAll(){
        return classRoomRepository.findAll();
    }

}
