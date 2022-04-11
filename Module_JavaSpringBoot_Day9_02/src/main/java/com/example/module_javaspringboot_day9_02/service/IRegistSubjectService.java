package com.example.module_javaspringboot_day9_02.service;

import com.example.module_javaspringboot_day9_02.dto.RegistSubjectDTO;

import java.util.List;

public interface IRegistSubjectService {
    List<RegistSubjectDTO> findAll();
    RegistSubjectDTO saveOrUpdate(RegistSubjectDTO registSubjectDTO);
    RegistSubjectDTO findById(Long id);
    void delete(Long ids);
    List<RegistSubjectDTO> findListSubjectNoneRegist(Long id_student);
    void studentRegistSubject(Long id_student, Long id_subject);
}
