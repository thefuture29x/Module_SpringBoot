package com.example.module_javaspringboot_day10.controller;

import com.example.module_javaspringboot_day10.dto.ClassRoomDTO;
import com.example.module_javaspringboot_day10.dto.StudentDTO;
import com.example.module_javaspringboot_day10.entities.StudentEntity;
import com.example.module_javaspringboot_day10.modal.ClassRoomModal;
import com.example.module_javaspringboot_day10.modal.StudentModal;
import com.example.module_javaspringboot_day10.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService iStudentService;

    @PostMapping("/save-student")
    public ResponseEntity<?> getHomePage(@RequestBody StudentDTO studentDTO) {
        List<ClassRoomModal> modals = new ArrayList<>();
        if (studentDTO.getId()== null){
            iStudentService.save(StudentDTO.toModal(studentDTO));
        }else {
            for (ClassRoomDTO classDTO: studentDTO.getClassRoomDTOList()) {
                modals.add(ClassRoomDTO.toModal(classDTO));
            }
            StudentModal dto = StudentDTO.toModal(studentDTO);
            dto.setClassRoomModalList(modals);
            iStudentService.save(dto);
        }
        return ResponseEntity.ok().body(studentDTO);
    }

    @GetMapping("/get-student")
    public ResponseEntity<?> getList(Pageable pageable) {
        List<StudentDTO> dtos = new ArrayList<>();
        for (StudentModal studentModal : iStudentService.findAll(pageable)) {
            List<ClassRoomDTO> classRoomDTOS = new ArrayList<>();
            for (ClassRoomModal classModal: studentModal.getClassRoomModalList()) {
                classRoomDTOS.add(ClassRoomModal.toDTO(classModal));
            }
            StudentDTO studentDTO = StudentModal.toDTO(studentModal);
            studentDTO.setClassRoomDTOList(classRoomDTOS);
            dtos.add(studentDTO);
        }
        return ResponseEntity.ok().body(dtos);
    }

    @DeleteMapping("/delete-student")
    public ResponseEntity<?> deleteStudent(@RequestBody StudentDTO studentDTO) {
        iStudentService.delete(Long.valueOf(studentDTO.getId()));
        return ResponseEntity.ok().body(studentDTO.getId());
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<?> getStudentById(@RequestBody StudentDTO studentDTO) {
        StudentModal studentModal = iStudentService.findById(studentDTO.getId());
        return ResponseEntity.ok().body(StudentModal.toDTO(studentModal));
    }

    @DeleteMapping("/delete-students")
    public ResponseEntity<?> deleteStudents(@RequestBody Long[] ids) {
        iStudentService.deletes(ids);
        return ResponseEntity.ok().body(ids);
    }


}
