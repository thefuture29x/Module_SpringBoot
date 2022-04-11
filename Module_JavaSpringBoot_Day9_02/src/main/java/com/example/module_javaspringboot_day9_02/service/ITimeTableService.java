package com.example.module_javaspringboot_day9_02.service;

import com.example.module_javaspringboot_day9_02.dto.TimeTableDTO;

import java.util.List;

public interface ITimeTableService {
    List<TimeTableDTO> findAll();
    TimeTableDTO saveOrUpdate(TimeTableDTO timeTableDTO);
    TimeTableDTO  findById(Long id);
    void delete(Long ids);
    List<TimeTableDTO> findAllByIdStudent(Long id_student);

}
