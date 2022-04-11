package com.example.module_javaspringboot_day9_02.convert;

import com.example.module_javaspringboot_day9_02.dto.StudentDTO;
import com.example.module_javaspringboot_day9_02.dto.SubjectDTO;
import com.example.module_javaspringboot_day9_02.dto.TimeTableDTO;
import com.example.module_javaspringboot_day9_02.entities.StudentEntity;
import com.example.module_javaspringboot_day9_02.entities.SubjectEntity;
import com.example.module_javaspringboot_day9_02.entities.TimeTableEntity;
import com.example.module_javaspringboot_day9_02.repository.IScoreRepository;
import com.example.module_javaspringboot_day9_02.repository.IStudentRepository;
import com.example.module_javaspringboot_day9_02.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class SubjectConvert {
//    @Autowired
//    IScoreRepository iScoreRepository;
//    @Autowired
//    IStudentRepository iStudentRepository;
//    @Autowired
//    TimeTableConvert timeTableConvert;
//    @Autowired
//    StudentConvert studentConvert;
//    @Autowired
//    ScoreConvert scoreConvert;

    public SubjectEntity toEntity(SubjectDTO dto){
        SubjectEntity entity = new SubjectEntity();
//        List<TimeTableEntity> timeTableEntities = new ArrayList<>();
//        List<StudentEntity> studentEntities = new ArrayList<>();
//        for (TimeTableDTO timeTableDTOs : dto.getTimeTableDTOs()) {
//            timeTableEntities.add(timeTableConvert.toEntity(timeTableDTOs));
//        }
//        for (StudentDTO studentDTO : dto.getStudentDTOs()) {
//            studentEntities.add(studentConvert.toEntity(studentDTO));
//        }

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTime(dto.getTime());
//        entity.setScoreEntity(scoreConvert.toEntity(dto.getScoreDTO()));
//        entity.setTimeTableEntity(timeTableEntities);
//        entity.setStudentEntityList(studentEntities);

        return entity;
    }
    public SubjectEntity toEntity(SubjectEntity entity,SubjectDTO dto){
//        List<TimeTableEntity> timeTableEntities = new ArrayList<>();
//        List<StudentEntity> studentEntities = new ArrayList<>();
//        for (TimeTableDTO timeTableDTOs : dto.getTimeTableDTOs()) {
//            timeTableEntities.add(timeTableConvert.toEntity(timeTableDTOs));
//        }
//        for (StudentDTO studentDTO : dto.getStudentDTOs()) {
//            studentEntities.add(studentConvert.toEntity(studentDTO));
//        }

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTime(dto.getTime());
//        entity.setScoreEntity(scoreConvert.toEntity(dto.getScoreDTO()));
//        entity.setTimeTableEntity(timeTableEntities);
//        entity.setStudentEntityList(studentEntities);

        return entity;
    }
    public SubjectDTO toDTO(SubjectEntity entity){
        SubjectDTO dto = new SubjectDTO();
//        List<TimeTableDTO> timeTableDTOS = new ArrayList<>();
//        List<StudentDTO> studentDTOS = new ArrayList<>();
//        for (TimeTableEntity timeTableEntity : entity.getTimeTableEntity()) {
//            timeTableDTOS.add(timeTableConvert.toDTO(timeTableEntity));
//        }
//        for (StudentEntity studentEntity : entity.getStudentEntityList()) {
//            studentDTOS.add(studentConvert.toDTO(studentEntity));
//        }

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setTime(entity.getTime());
//        dto.setScoreDTO(scoreConvert.toDTO(entity.getScoreEntity()));
//        dto.setStudentDTOs(studentDTOS);
//        dto.setTimeTableDTOs(timeTableDTOS);

        return dto;
    }

}
