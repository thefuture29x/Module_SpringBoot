package com.example.module_javaspringboot_day9.service;

import com.example.module_javaspringboot_day9.dto.ScoreDTO;
import com.example.module_javaspringboot_day9.dto.StudentDTO;

import java.util.List;

public interface IScoreService {
    List<ScoreDTO> findAll();
    Long saveOrUpdate(ScoreDTO ScoreDTO);
    ScoreDTO findById(Long id);
    void delete(Long ids);
    List<ScoreDTO> findAllByIdStudent(Long id_student);
}
