package com.example.module_javaspringboot_day18_01_security.repository;

import com.example.module_javaspringboot_day18_01_security.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IUserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByUsername(String username);
}
