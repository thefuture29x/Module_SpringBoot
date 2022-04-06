package com.example.module_javaspringboot_day7_02.convert;

import com.example.module_javaspringboot_day7_02.dao.EmployeeDAO;
import com.example.module_javaspringboot_day7_02.dto.EmployeeDTO;
import com.example.module_javaspringboot_day7_02.entities.EmployeeEntity;

public class EmployeeConvert {
    public EmployeeEntity toEntity(EmployeeDTO dto){
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        entity.setEmpDepartment(dto.getDepartment());
        entity.setEmpPosition(dto.getPosition());
        return entity;
    }

    public EmployeeDTO toDTO(EmployeeEntity entity){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhone(entity.getPhone());
        dto.setAddress(entity.getAddress());
        dto.setId_depart(entity.getEmpDepartment().getId());
        dto.setId_post(entity.getEmpPosition().getId());
        dto.setDepartment(entity.getEmpDepartment());
        dto.setPosition(entity.getEmpPosition());
        return dto;
    }
 }
