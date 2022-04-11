package com.example.module_javaspringboot_day9_02.service;

import com.example.module_javaspringboot_day9_02.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> findAll();
    StudentDTO saveOrUpdate(StudentDTO tableDTO);
    StudentDTO findById(Long id);
    void delete(Long ids);
}
