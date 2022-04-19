package com.example.module_javaspingboot_day15.controller;

import com.example.module_javaspingboot_day15.entities.ClassRoomEntity;
import com.example.module_javaspingboot_day15.entities.TeacherEntity;
import com.example.module_javaspingboot_day15.repository.ClassRoomRepository;
import com.example.module_javaspingboot_day15.repository.TeacherRepository;
import com.example.module_javaspingboot_day15.service.IClassRoomService;
import com.example.module_javaspingboot_day15.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class ClassRoomController {
    @Autowired
    ClassRoomRepository classRoomRepository;
    @Autowired
    IClassRoomService iClassRoomService;

    @GetMapping("/get-classroom")
    public Response<List<ClassRoomEntity>> getAll(Pageable pageable){
        return Response.ofSucceeded(iClassRoomService.findAllClassRoom(pageable));// lấy ra danh sách toàn bộ ClassRoom với list Teacher thuộc ClassRoom đó
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Long id){
    }

    @GetMapping("/test-get-classroom")
    public Flux<ClassRoomEntity> testGetAll(){
        return classRoomRepository.findAll();
    }

}
