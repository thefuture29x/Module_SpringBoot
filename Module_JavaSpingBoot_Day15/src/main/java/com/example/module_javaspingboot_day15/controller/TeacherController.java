package com.example.module_javaspingboot_day15.controller;

import com.example.module_javaspingboot_day15.dto.InforDTO;
import com.example.module_javaspingboot_day15.dto.TeacherDTO;
import com.example.module_javaspingboot_day15.entities.TeacherEntity;
import com.example.module_javaspingboot_day15.repository.TeacherRepository;
import com.example.module_javaspingboot_day15.service.ITeacherService;
import com.example.module_javaspingboot_day15.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RestController
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    ITeacherService iTeacherService;

    @GetMapping("/get-teacher")
    public Flux<TeacherEntity> getAll(Pageable pageable){
        return teacherRepository.findAllBy(pageable);
    }

    @GetMapping("/get-all-teacher")
    public Response<Flux<TeacherEntity>> getAllTC(Pageable pageable){
        Flux<TeacherEntity> flux = teacherRepository.findAllBy(pageable);
        Long totalItems = teacherRepository.count().block();
        return Response.ofSucceeded(flux.toStream().collect(Collectors.toList()), pageable,totalItems);
    }

    @PostMapping("/save-teacher")
    public Mono<TeacherEntity> save(@RequestBody TeacherDTO teacherDTO){
        return iTeacherService.save(teacherDTO);
    }
    @DeleteMapping("/delete")
    public Mono delete(@RequestBody Long id){
        return teacherRepository.deleteById(id);
    }
}
