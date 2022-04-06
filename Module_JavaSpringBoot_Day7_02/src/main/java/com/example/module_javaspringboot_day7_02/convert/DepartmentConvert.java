package com.example.module_javaspringboot_day7_02.convert;

import com.example.module_javaspringboot_day7_02.dto.DepartmentDTO;
import com.example.module_javaspringboot_day7_02.entities.DepartmentEntity;

public class DepartmentConvert {
    public DepartmentEntity toEntity(DepartmentDTO dto){
        DepartmentEntity entity = new DepartmentEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public DepartmentDTO toDTO(DepartmentEntity entity){
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
 }
