package com.example.module_javaspringboot_finalproject.dto;

import com.example.module_javaspringboot_finalproject.config.AuthProvider;
import com.example.module_javaspringboot_finalproject.entities.CategoryEntity;
import com.example.module_javaspringboot_finalproject.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private boolean enabled;
    private String avatar;

    private AuthProvider authProvider;

    private List<RoleDTO> roleDTOList;

    public static UserEntity toEntity(UserDTO dto){
        return UserEntity.builder()
                .id(dto.id)
                .username(dto.username)
                .email(dto.email)
                .enabled(dto.enabled)
                .authProvider(dto.authProvider)
                .avatar(dto.avatar)
                .build();
    }
}
