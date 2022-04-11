package com.example.module_javaspringboot_day9_02.service;

import com.example.module_javaspringboot_day9_02.dto.SubjectDTO;

import java.util.List;

public interface ISubjectService {
    List<SubjectDTO> findAll();
    SubjectDTO saveOrUpdate(SubjectDTO SubjectDTO);
    SubjectDTO findById(Long id);
    void delete(Long ids);
    List<SubjectDTO> getListSubject();
    SubjectDTO findTimeTableByNameSubject(String subject_name);
    SubjectDTO registSubject(Long id_subject);
}
