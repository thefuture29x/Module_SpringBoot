package com.example.module_javaspringboot_day18_01_security.repository;

import com.example.module_javaspringboot_day18_01_security.entities.PermissionEntity;
import com.example.module_javaspringboot_day18_01_security.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPermissionRepository extends JpaRepository<PermissionEntity,Long> {
}
