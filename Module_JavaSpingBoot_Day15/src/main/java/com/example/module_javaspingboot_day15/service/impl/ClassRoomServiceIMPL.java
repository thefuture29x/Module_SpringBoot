package com.example.module_javaspingboot_day15.service.impl;

import com.example.module_javaspingboot_day15.entities.ClassRoomEntity;
import com.example.module_javaspingboot_day15.entities.TeacherEntity;
import com.example.module_javaspingboot_day15.repository.ClassRoomRepository;
import com.example.module_javaspingboot_day15.repository.TeacherRepository;
import com.example.module_javaspingboot_day15.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassRoomServiceIMPL implements IClassRoomService {
    @Autowired
    ClassRoomRepository classRoomRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Override
    public List<ClassRoomEntity> findAllClassRoom(Pageable pageable) {
        List<ClassRoomEntity> entityListFlux = classRoomRepository.findAll().collectList().block();// lấy ra danh sách toàn bộ classrooom và ép kiểu từ Flux về List.
        List<ClassRoomEntity> newFlux = new ArrayList<>();// tạo một List ClassRoom mới để lưu các ClassRoom khi đã set đủ thong tin
        for (ClassRoomEntity classE : entityListFlux) {// lấy từng phần tử ClassRoom trong List
            classE.setTeacherEntityList(teacherRepository.findById_classroom(classE.getId()).collectList().block());//Tìm kiếm một List Teacher có id_classroom tương ứng với id của classroom đang xét. Set list Teacher vào đối tượng ClassRoom
            newFlux.add(classE);// Add đối tượng ClassRoom mới đã có đủ thông tin lớp con vào List mới
        }
        return newFlux;// trả về List ClassRoom với thông tin đầy đủ lớp con
    }
}
