package com.example.module_javaspringboot_day9.service.impl;

import com.example.module_javaspringboot_day9.convert.ScoreConvert;
import com.example.module_javaspringboot_day9.dto.ScoreDTO;
import com.example.module_javaspringboot_day9.dto.ScoreDTO;
import com.example.module_javaspringboot_day9.entities.ScoreEntity;
import com.example.module_javaspringboot_day9.repository.IScoreRepository;
import com.example.module_javaspringboot_day9.repository.IStudentRepository;
import com.example.module_javaspringboot_day9.service.IScoreService;
import com.example.module_javaspringboot_day9.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceIMPL implements IScoreService {
    @Autowired
    IScoreRepository ScoreRepository;
    @Autowired
    IStudentService iStudentService;
    @Autowired
    ScoreConvert ScoreConvert;
    @Autowired
    IStudentRepository iStudentRepository;

    @Override
    public List<ScoreDTO> findAll() {
        List<ScoreDTO> dtoList = new ArrayList<>();
        for (ScoreEntity entity: ScoreRepository.findAll()) {
            dtoList.add(ScoreConvert.toDTO(entity));
        }
        return dtoList;
    }

    @Override
    public Long saveOrUpdate(ScoreDTO ScoreDTO) {
        if (ScoreDTO.getId() == null){
            ScoreEntity newScore = ScoreConvert.toEntity(ScoreDTO);
            newScore.setStudentEntity(iStudentRepository.getById(ScoreDTO.getId_student()));
            return ScoreRepository.save(newScore).getId();
        }else {
            ScoreEntity oldEntity = ScoreRepository.getById(ScoreDTO.getId());
            ScoreEntity newEntity = ScoreConvert.toEntity(oldEntity,ScoreDTO);
            newEntity.setStudentEntity(iStudentRepository.getById(ScoreDTO.getId_student()));
            return ScoreRepository.save(newEntity).getId();
        }
    }

    @Override
    public ScoreDTO findById(Long id) {
        return ScoreConvert.toDTO(ScoreRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        ScoreRepository.deleteById(id);
    }

    @Override
    public List<ScoreDTO> findAllByIdStudent(Long id_student) {
        List<ScoreEntity> listScore = ScoreRepository.findAllByStudentEntity(iStudentRepository.getById(id_student));
        List<ScoreDTO> dtoList = new ArrayList<>();
        for (ScoreEntity ent :
                listScore) {
            dtoList.add(ScoreConvert.toDTO(ent));
        }
        return dtoList;
    }


}
