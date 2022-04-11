package com.example.module_javaspringboot_day9.service;

import com.example.module_javaspringboot_day9.dto.StudentDTO;
import com.example.module_javaspringboot_day9.dto.SubjectDTO;
import com.example.module_javaspringboot_day9.dto.TimeTableDTO;

import java.util.List;

public interface ITimeTableService {
    List<TimeTableDTO> findAll();
    void saveOrUpdate(TimeTableDTO timeTableDTO);
    TimeTableDTO  findById(Long id);
    void delete(Long ids);
    List<TimeTableDTO> findAllByIdStudent(Long id_student);
    List<SubjectDTO> getListSubject();
    SubjectDTO findTimeTableByNameSubject(String subject_name);
}
