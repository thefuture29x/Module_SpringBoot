package com.example.module_javaspringboot_day9.service;

import com.example.module_javaspringboot_day9.dto.RegistSubjectDTO;
import com.example.module_javaspringboot_day9.dto.StudentDTO;

import java.util.List;

public interface IRegistSubjectService {
    List<RegistSubjectDTO> findAll();
    void saveOrUpdate(RegistSubjectDTO registSubjectDTO);
    RegistSubjectDTO findById(Long id);
    void delete(Long ids);
    List<RegistSubjectDTO> findListSubjectNoneRegist(Long id_student);
}
