package com.example.module_javaspringboot_day18_01_security.repository;

import com.example.module_javaspringboot_day18_01_security.entities.RoleEntity;
import com.example.module_javaspringboot_day18_01_security.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {
    RoleEntity findByRole(String role);
}
