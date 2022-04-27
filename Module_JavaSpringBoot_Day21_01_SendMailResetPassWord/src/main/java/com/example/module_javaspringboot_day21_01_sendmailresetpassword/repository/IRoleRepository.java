package com.example.module_javaspringboot_day21_01_sendmailresetpassword.repository;

import com.example.module_javaspringboot_day21_01_sendmailresetpassword.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {
}
