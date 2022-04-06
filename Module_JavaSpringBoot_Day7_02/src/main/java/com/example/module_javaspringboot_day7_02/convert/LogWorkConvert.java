package com.example.module_javaspringboot_day7_02.convert;

import com.example.module_javaspringboot_day7_02.dto.LogWorkDTO;
import com.example.module_javaspringboot_day7_02.entities.LogWorkEntity;

public class LogWorkConvert {
    public LogWorkEntity toEntity(LogWorkDTO dto){
        LogWorkEntity entity = new LogWorkEntity();
        entity.setId(dto.getId());
        entity.setDate_start(dto.getDate_start());
        entity.setWork_hours(dto.getWork_hours());
        entity.setDescription(dto.getDescription());
        entity.setEmp_logwork(dto.getEmp_logwork());
        return entity;
    }

    public LogWorkDTO toDTO(LogWorkEntity entity){
        LogWorkDTO dto = new LogWorkDTO();
        dto.setId(entity.getId());
        dto.setDate_start(entity.getDate_start());
        dto.setWork_hours(entity.getWork_hours());
        dto.setDescription(entity.getDescription());
        dto.setEmp_logwork(entity.getEmp_logwork());
        return dto;
    }
 }
