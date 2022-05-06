package com.example.module_javaspringboot_finalproject.repository;

import com.example.module_javaspringboot_finalproject.entities.CategoryEntity;
import com.example.module_javaspringboot_finalproject.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
    UserEntity findByResetPassWordToken(String token);
}
