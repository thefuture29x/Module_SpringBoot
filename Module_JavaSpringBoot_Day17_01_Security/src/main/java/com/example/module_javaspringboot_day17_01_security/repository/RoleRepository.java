package com.example.module_javaspringboot_day17_01_security.repository;

import com.example.module_javaspringboot_day17_01_security.entities.RoleEntity;
import com.example.module_javaspringboot_day17_01_security.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    RoleEntity findByRole(String name);
}
