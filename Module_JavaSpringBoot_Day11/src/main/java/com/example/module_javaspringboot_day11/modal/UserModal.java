package com.example.module_javaspringboot_day11.modal;

import com.example.module_javaspringboot_day11.dto.UserDTO;
import com.example.module_javaspringboot_day11.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModal {
    private Long id;
    private String username;
    private String password;

    private static UserEntity toEntity(UserModal old){
        return UserEntity.builder()
                .id(old.id)
                .username(old.username)
                .password(old.password).build();
    }
    private static UserDTO toDTO(UserModal old){
        return UserDTO.builder()
                .id(old.id)
                .username(old.username)
                .password(old.password).build();
    }


}
