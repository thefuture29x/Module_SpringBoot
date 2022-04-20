package com.example.module_javaspingboot_day16_02_practicejpa.controller;

import com.example.module_javaspingboot_day16_02_practicejpa.dto.ClassRoomDTO;
import com.example.module_javaspingboot_day16_02_practicejpa.entities.ClassRoomEntity;
import com.example.module_javaspingboot_day16_02_practicejpa.repository.IClassRepository2;
import com.example.module_javaspingboot_day16_02_practicejpa.repository.IClassRoomRepository;
import com.example.module_javaspingboot_day16_02_practicejpa.repository.IStudentRepository;
import com.example.module_javaspingboot_day16_02_practicejpa.specification.ClassRoomSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ClassRoomController {
    @Autowired
    IClassRoomRepository iClassRoomRepository;

    @Autowired
    IClassRepository2 iClassRepository2;

    @Autowired
    IStudentRepository iStudentRepository;

    @GetMapping("/get-classroom")
    public ResponseEntity<?> getAllClassRoom(){
        Specification specification = Specification.where(ClassRoomSpecification.findById(1L));
        ClassRoomEntity classRoomEntity = (ClassRoomEntity) iClassRoomRepository.findAll(specification).get(0);
        return ResponseEntity.ok().body(iClassRepository2.findAll());
    }
    @GetMapping("/get-student")
    public ResponseEntity<?> getAllStudent(){
//        Specification specification = Specification.where(ClassRoomSpecification.findById(1L));
//        ClassRoomEntity classRoomEntity = (ClassRoomEntity) iClassRoomRepository.findAll(specification).get(0);
        return ResponseEntity.ok().body(iStudentRepository.findAll());
    }
}
