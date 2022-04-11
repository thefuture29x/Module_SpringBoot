package com.example.module_javaspringboot_day9.convert;

import com.example.module_javaspringboot_day9.dto.TimeTableDTO;
import com.example.module_javaspringboot_day9.entities.TimeTableEntity;
import org.springframework.stereotype.Component;

@Component
public class TimeTableConvert {

    public TimeTableEntity toEntity(TimeTableDTO dto){
        TimeTableEntity entity = new TimeTableEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTime(dto.getTime());
        entity.setStatus(dto.getStatus());
        return entity;
    }
    public TimeTableEntity toEntity(TimeTableEntity entity,TimeTableDTO dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTime(dto.getTime());
        entity.setStatus(dto.getStatus());
        return entity;
    }
    public TimeTableDTO toDTO(TimeTableEntity entity){
        TimeTableDTO dto = new TimeTableDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setTime(entity.getTime());
        dto.setStatus(entity.getStatus());
        dto.setId_timeTable(entity.getStudentTimeTable().getId());
        return dto;
    }

}
