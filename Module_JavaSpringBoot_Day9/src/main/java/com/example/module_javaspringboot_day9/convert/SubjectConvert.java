package com.example.module_javaspringboot_day9.convert;

import com.example.module_javaspringboot_day9.dto.SubjectDTO;
import com.example.module_javaspringboot_day9.entities.SubjectEntity;
import org.springframework.stereotype.Component;

@Component
public class SubjectConvert {

    public SubjectEntity toEntity(SubjectDTO dto){
        SubjectEntity entity = new SubjectEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTime(dto.getTime());
        return entity;
    }
    public SubjectEntity toEntity(SubjectEntity entity,SubjectDTO dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTime(dto.getTime());
        return entity;
    }
    public SubjectDTO toDTO(SubjectEntity entity){
        SubjectDTO dto = new SubjectDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setTime(entity.getTime());
        dto.setId_score(entity.getScoreEntity().getId());
        return dto;
    }

}
