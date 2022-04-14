package com.example.module_javaspringboot_day11.dto;

import com.example.module_javaspringboot_day11.entities.UserEntity;
import com.example.module_javaspringboot_day11.modal.UserModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;

    private static UserEntity toEntity(UserDTO old){
        return UserEntity.builder()
                .id(old.id)
                .username(old.username)
                .password(old.password).build();
    }
    private static UserModal toModal(UserDTO old){
        return UserModal.builder()
                .id(old.id)
                .username(old.username)
                .password(old.password).build();
    }

}
