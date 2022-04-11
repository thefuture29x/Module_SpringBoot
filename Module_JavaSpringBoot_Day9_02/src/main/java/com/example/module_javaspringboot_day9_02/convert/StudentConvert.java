package com.example.module_javaspringboot_day9_02.convert;

import com.example.module_javaspringboot_day9_02.dto.ScoreDTO;
import com.example.module_javaspringboot_day9_02.dto.StudentDTO;
import com.example.module_javaspringboot_day9_02.dto.SubjectDTO;
import com.example.module_javaspringboot_day9_02.dto.TimeTableDTO;
import com.example.module_javaspringboot_day9_02.entities.ScoreEntity;
import com.example.module_javaspringboot_day9_02.entities.StudentEntity;
import com.example.module_javaspringboot_day9_02.entities.SubjectEntity;
import com.example.module_javaspringboot_day9_02.entities.TimeTableEntity;
import com.example.module_javaspringboot_day9_02.repository.IScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class StudentConvert {
//    @Autowired
//    IScoreRepository iScoreRepository;
//    @Autowired
//    ScoreConvert scoreConvert;
//    @Autowired
//    TimeTableConvert timeTableConvert;
//    @Autowired
//    SubjectConvert subjectConvert;

    public StudentEntity toEntity(StudentDTO dto){
        StudentEntity entity = new StudentEntity();
//        List<ScoreEntity> scoreEntities = new ArrayList<>();
//        Set<SubjectEntity> subjectEntities = new HashSet<>();
//        List<TimeTableEntity> timeTableEntities = new ArrayList<>();
//        for (ScoreDTO scoreDTOs : dto.getScoreDTOS()) {
//            scoreEntities.add(scoreConvert.toEntity(scoreDTOs));
//        }
//        for (TimeTableDTO timeTableDTOs : dto.getTimeTableDTOS()) {
//            timeTableEntities.add(timeTableConvert.toEntity(timeTableDTOs));
//        }
//        for (SubjectDTO subjectDTOs : dto.getSubjectDTOS()) {
//            subjectEntities.add(subjectConvert.toEntity(subjectDTOs));
//        }

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
//        entity.setListScore(scoreEntities);
//        entity.setListSubject(subjectEntities);
//        entity.setTimeTableEntityList(timeTableEntities);

        return entity;
    }
    public StudentEntity toEntity(StudentEntity entity,StudentDTO dto){
//        List<ScoreEntity> scoreEntities = new ArrayList<>();
//        Set<SubjectEntity> subjectEntities = new HashSet<>();
//        List<TimeTableEntity> timeTableEntities = new ArrayList<>();
//        for (ScoreDTO scoreDTOs : dto.getScoreDTOS()) {
//            scoreEntities.add(scoreConvert.toEntity(scoreDTOs));
//        }
//        for (TimeTableDTO timeTableDTOs : dto.getTimeTableDTOS()) {
//            timeTableEntities.add(timeTableConvert.toEntity(timeTableDTOs));
//        }
//        for (SubjectDTO subjectDTOs : dto.getSubjectDTOS()) {
//            subjectEntities.add(subjectConvert.toEntity(subjectDTOs));
//        }

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
//        entity.setListScore(scoreEntities);
//        entity.setListSubject(subjectEntities);
//        entity.setTimeTableEntityList(timeTableEntities);

        return entity;
    }
    public StudentDTO toDTO(StudentEntity entity){
        StudentDTO dto = new StudentDTO();
//        List<ScoreDTO> scoreDTOS = new ArrayList<>();
//        Set<SubjectDTO> subjectDTOS = new HashSet<>();
//        List<TimeTableDTO> timeTableDTOS = new ArrayList<>();
//        for (ScoreEntity scoreEntity : entity.getListScore()) {
//            scoreDTOS.add(scoreConvert.toDTO(scoreEntity));
//        }
//        for (TimeTableEntity timeTableEntity : entity.getTimeTableEntityList()) {
//            timeTableDTOS.add(timeTableConvert.toDTO(timeTableEntity));
//        }
//        for (SubjectEntity subjectEntity : entity.getListSubject()) {
//            subjectDTOS.add(subjectConvert.toDTO(subjectEntity));
//        }

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhoneNumber(entity.getPhoneNumber());
//        dto.setScoreDTOS(scoreDTOS);
//        dto.setSubjectDTOS(subjectDTOS);
//        dto.setTimeTableDTOS(timeTableDTOS);

        return dto;
    }

}
