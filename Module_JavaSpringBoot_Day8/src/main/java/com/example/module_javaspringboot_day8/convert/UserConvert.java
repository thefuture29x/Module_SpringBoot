package com.example.module_javaspringboot_day8.convert;

import com.example.module_javaspringboot_day8.dto.UserDTO;
import com.example.module_javaspringboot_day8.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConvert {
    public UserEntity toEntity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public UserDTO toDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
    public UserEntity toEntity(UserEntity entity,UserDTO dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
