package com.example.module_javaspringboot_finalproject.dto;

import com.example.module_javaspringboot_finalproject.entities.CategoryEntity;
import com.example.module_javaspringboot_finalproject.entities.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private Long id;
    private String role;

    private List<UserDTO> userDTOList;

    public static RoleEntity toEntity(RoleDTO dto){
        return RoleEntity.builder()
                .id(dto.id)
                .role(dto.role)
                .build();
    }
}
