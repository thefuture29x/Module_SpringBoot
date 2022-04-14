package com.example.module_javaspringboot_day11.entities;

import com.example.module_javaspringboot_day11.dto.UserDTO;
import com.example.module_javaspringboot_day11.modal.UserModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;


    private static UserDTO toDTO(UserEntity old){
        return UserDTO.builder()
                .id(old.id)
                .username(old.username)
                .password(old.password).build();
    }
    private static UserModal toModal(UserEntity old){
        return UserModal.builder()
                .id(old.id)
                .username(old.username)
                .password(old.password).build();
    }

}
