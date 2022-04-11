package com.example.module_javaspringboot_day9_02.convert;

import com.example.module_javaspringboot_day9_02.dto.ScoreDTO;
import com.example.module_javaspringboot_day9_02.entities.ScoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScoreConvert {
//    @Autowired
//    StudentConvert studentConvert;
//    @Autowired
//    SubjectConvert subjectConvert;

    public ScoreEntity toEntity(ScoreDTO dto){
        ScoreEntity entity = new ScoreEntity();
        entity.setId(dto.getId());
        entity.setTestScore(dto.getTestScore());
        entity.setProcessScore(dto.getProcessScore());
        entity.setFinalScore(dto.getFinalScore());
//        entity.setStudentEntity(studentConvert.toEntity(dto.getStudentDTO()));
//        entity.setSubjectEntity(subjectConvert.toEntity(dto.getSubjectDTO()));
        return entity;
    }
    public ScoreEntity toEntity(ScoreEntity entity,ScoreDTO dto){
        entity.setId(dto.getId());
        entity.setTestScore(dto.getTestScore());
        entity.setProcessScore(dto.getProcessScore());
        entity.setFinalScore(dto.getFinalScore());
//        entity.setStudentEntity(studentConvert.toEntity(dto.getStudentDTO()));
//        entity.setSubjectEntity(subjectConvert.toEntity(dto.getSubjectDTO()));
        return entity;
    }
    public ScoreDTO toDTO(ScoreEntity entity){
        ScoreDTO dto = new ScoreDTO();
        dto.setId(entity.getId());
        dto.setTestScore(entity.getTestScore());
        dto.setProcessScore(entity.getProcessScore());
        dto.setFinalScore(entity.getFinalScore());
//        dto.setStudentDTO(studentConvert.toDTO(entity.getStudentEntity()));
//        dto.setSubjectDTO(subjectConvert.toDTO(entity.getSubjectEntity()));
        return dto;
    }

}
