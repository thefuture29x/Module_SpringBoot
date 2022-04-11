package com.example.module_javaspringboot_day9.service;

import com.example.module_javaspringboot_day9.dto.StudentDTO;
import com.example.module_javaspringboot_day9.dto.SubjectDTO;

import java.util.List;

public interface ISubjectService {
    List<SubjectDTO> findAll();
    SubjectDTO saveOrUpdate(SubjectDTO SubjectDTO);
    SubjectDTO findById(Long id);
    void delete(Long ids);
    Long lastIDSubject();
}
