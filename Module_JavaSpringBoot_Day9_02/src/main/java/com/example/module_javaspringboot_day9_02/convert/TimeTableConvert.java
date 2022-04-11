package com.example.module_javaspringboot_day9_02.convert;

import com.example.module_javaspringboot_day9_02.dto.TimeTableDTO;
import com.example.module_javaspringboot_day9_02.entities.TimeTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimeTableConvert {
//    @Autowired
//    StudentConvert studentConvert;
//    @Autowired
//    SubjectConvert subjectConvert;

    public TimeTableEntity toEntity(TimeTableDTO dto){
        TimeTableEntity entity = new TimeTableEntity();
        entity.setId(dto.getId());
        entity.setStatus(dto.getStatus());
//        entity.setSubjectEntity(subjectConvert.toEntity(dto.getSubjectDTO()));
//        entity.setStudentTimeTable(studentConvert.toEntity(dto.getStudentDTO()));
        return entity;
    }
    public TimeTableEntity toEntity(TimeTableEntity entity,TimeTableDTO dto){
        entity.setId(dto.getId());
        entity.setStatus(dto.getStatus());
//        entity.setSubjectEntity(subjectConvert.toEntity(dto.getSubjectDTO()));
//        entity.setStudentTimeTable(studentConvert.toEntity(dto.getStudentDTO()));
        return entity;
    }
    public TimeTableDTO toDTO(TimeTableEntity entity){
        TimeTableDTO dto = new TimeTableDTO();
        dto.setId(entity.getId());
        dto.setStatus(entity.getStatus());
//        dto.setStudentDTO(studentConvert.toDTO(entity.getStudentTimeTable()));
//        dto.setSubjectDTO(subjectConvert.toDTO(entity.getSubjectEntity()));
        return dto;
    }

}
