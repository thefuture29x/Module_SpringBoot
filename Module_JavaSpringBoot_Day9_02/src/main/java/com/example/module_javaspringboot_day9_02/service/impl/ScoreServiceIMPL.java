package com.example.module_javaspringboot_day9_02.service.impl;

import com.example.module_javaspringboot_day9_02.convert.ScoreConvert;
import com.example.module_javaspringboot_day9_02.dto.ScoreDTO;
import com.example.module_javaspringboot_day9_02.dto.ScoreDTO;
import com.example.module_javaspringboot_day9_02.entities.ScoreEntity;
import com.example.module_javaspringboot_day9_02.repository.IScoreRepository;
import com.example.module_javaspringboot_day9_02.repository.IStudentRepository;
import com.example.module_javaspringboot_day9_02.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceIMPL implements IScoreService {
    @Autowired
    IScoreRepository iScoreRepository;
    @Autowired
    ScoreConvert scoreConvert;
    @Autowired
    IStudentRepository iStudentRepository;

    @Override
    public List<ScoreDTO> findAll() {
        List<ScoreDTO> dtoList = new ArrayList<>();
        for (ScoreEntity entity: iScoreRepository.findAll()) {
            dtoList.add(scoreConvert.toDTO(entity));
        }
        return dtoList;
    }

    @Override
    public ScoreDTO saveOrUpdate(ScoreDTO ScoreDTO) {
        if (ScoreDTO.getId() == null){
            return scoreConvert.toDTO(iScoreRepository.save(scoreConvert.toEntity(ScoreDTO)));
        }else {
            ScoreEntity oldEntity = iScoreRepository.getById(ScoreDTO.getId());
            ScoreEntity newEntity = scoreConvert.toEntity(oldEntity,ScoreDTO);
            return scoreConvert.toDTO(iScoreRepository.save(newEntity));
        }
    }

    @Override
    public ScoreDTO findById(Long id) {
        return scoreConvert.toDTO(iScoreRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        iScoreRepository.deleteById(id);
    }

    @Override
    public List<ScoreDTO> findAllByIdStudent(Long id_student) {
        List<ScoreDTO> dtoList = new ArrayList<>();
        for (ScoreEntity scoreEntitys : iScoreRepository.findAllByStudentEntity(iStudentRepository.getById(id_student))) {
            dtoList.add(scoreConvert.toDTO(scoreEntitys));
        }
        return dtoList;
    }


}
