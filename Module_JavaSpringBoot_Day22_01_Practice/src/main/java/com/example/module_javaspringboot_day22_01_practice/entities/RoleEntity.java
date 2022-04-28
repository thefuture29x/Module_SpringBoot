package com.example.module_javaspringboot_day22_01_practice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "role")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;

    @JsonIgnoreProperties("roleEntityList")
    @ManyToMany(mappedBy = "roleEntityList")
    private List<UserEntity> userEntityList;


}
