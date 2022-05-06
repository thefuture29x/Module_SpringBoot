package com.example.module_javaspringboot_finalproject.entities;

import com.example.module_javaspringboot_finalproject.dto.RoleDTO;
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
@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;

    @ManyToMany(mappedBy = "roleEntityList")
    private List<UserEntity> userEntityList;

    public static RoleDTO toDTO(RoleEntity entity){
        return RoleDTO.builder()
                .id(entity.id)
                .role(entity.role)
                .build();
    }
}
