package com.example.module_javaspringboot_day8.repository;

import com.example.module_javaspringboot_day8.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
