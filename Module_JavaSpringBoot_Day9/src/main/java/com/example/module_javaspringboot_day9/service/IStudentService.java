package com.example.module_javaspringboot_day9.service;

import com.example.module_javaspringboot_day9.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> findAll();
    void saveOrUpdate(StudentDTO tableDTO);
    StudentDTO findById(Long id);
    void delete(Long ids);
}
