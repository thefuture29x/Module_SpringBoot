package com.example.module_javaspringboot_day9.convert;

import com.example.module_javaspringboot_day9.dto.StudentDTO;
import com.example.module_javaspringboot_day9.entities.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentConvert {

    public StudentEntity toEntity(StudentDTO dto){
        StudentEntity entity = new StudentEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        return entity;
    }
    public StudentEntity toEntity(StudentEntity entity,StudentDTO dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        return entity;
    }
    public StudentDTO toDTO(StudentEntity entity){
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhoneNumber(entity.getPhoneNumber());
        return dto;
    }

}
