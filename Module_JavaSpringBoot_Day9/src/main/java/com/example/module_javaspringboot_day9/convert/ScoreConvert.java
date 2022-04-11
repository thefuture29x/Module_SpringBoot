package com.example.module_javaspringboot_day9.convert;

import com.example.module_javaspringboot_day9.dto.ScoreDTO;
import com.example.module_javaspringboot_day9.entities.ScoreEntity;
import org.springframework.stereotype.Component;

@Component
public class ScoreConvert {

    public ScoreEntity toEntity(ScoreDTO dto){
        ScoreEntity entity = new ScoreEntity();
        entity.setId(dto.getId());
        entity.setTestScore(dto.getTestScore());
        entity.setProcessScore(dto.getProcessScore());
        entity.setFinalScore(dto.getFinalScore());
        return entity;
    }
    public ScoreEntity toEntity(ScoreEntity entity,ScoreDTO dto){
        entity.setId(dto.getId());
        entity.setTestScore(dto.getTestScore());
        entity.setProcessScore(dto.getProcessScore());
        entity.setFinalScore(dto.getFinalScore());
        return entity;
    }
    public ScoreDTO toDTO(ScoreEntity entity){
        ScoreDTO dto = new ScoreDTO();
        dto.setId(entity.getId());
        dto.setTestScore(entity.getTestScore());
        dto.setProcessScore(entity.getProcessScore());
        dto.setFinalScore(entity.getFinalScore());
        dto.setId_student(entity.getStudentEntity().getId());
        dto.setId_subject(entity.getSubjectEntity().getId());
        return dto;
    }

}
