package com.example.module_javaspringboot_day7_02.convert;

import com.example.module_javaspringboot_day7_02.dto.PositionDTO;
import com.example.module_javaspringboot_day7_02.entities.PositionEntity;

public class PositionConvert {
    public PositionEntity toEntity(PositionDTO dto){
        PositionEntity entity = new PositionEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCfc_salary(dto.getCfc_salary());
        entity.setA_days_wages(dto.getA_days_wages());
        return entity;
    }

    public PositionDTO toDTO(PositionEntity entity){
        PositionDTO dto = new PositionDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCfc_salary(entity.getCfc_salary());
        dto.setA_days_wages(entity.getA_days_wages());
        return dto;
    }
 }
