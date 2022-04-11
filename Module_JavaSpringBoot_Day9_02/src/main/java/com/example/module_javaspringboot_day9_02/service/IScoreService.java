package com.example.module_javaspringboot_day9_02.service;

import com.example.module_javaspringboot_day9_02.dto.ScoreDTO;

import java.util.List;

public interface IScoreService {
    List<ScoreDTO> findAll();
    ScoreDTO saveOrUpdate(ScoreDTO ScoreDTO);
    ScoreDTO findById(Long id);
    void delete(Long ids);
    List<ScoreDTO> findAllByIdStudent(Long id_student);
}
