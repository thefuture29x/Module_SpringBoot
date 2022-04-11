package com.example.module_javaspringboot_day9_02.convert;

import com.example.module_javaspringboot_day9_02.dto.RegistSubjectDTO;
import com.example.module_javaspringboot_day9_02.entities.RegistSubjectEntity;
import org.springframework.stereotype.Component;

@Component
public class RegistSubjectConvert {

    public RegistSubjectEntity toEntity(RegistSubjectDTO dto){
        RegistSubjectEntity entity = new RegistSubjectEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTime(dto.getTime());
        entity.setLimitQuantity(dto.getLimitQuantity());
        return entity;
    }
    public RegistSubjectEntity toEntity(RegistSubjectEntity entity,RegistSubjectDTO dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTime(dto.getTime());
        entity.setLimitQuantity(dto.getLimitQuantity());
        return entity;
    }
    public RegistSubjectDTO toDTO(RegistSubjectEntity entity){
        RegistSubjectDTO dto = new RegistSubjectDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setTime(entity.getTime());
        dto.setLimitQuantity(entity.getLimitQuantity());
        return dto;
    }

}
