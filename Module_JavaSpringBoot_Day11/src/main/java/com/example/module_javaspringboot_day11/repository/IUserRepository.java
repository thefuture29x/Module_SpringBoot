package com.example.module_javaspringboot_day11.repository;

import com.example.module_javaspringboot_day11.entities.UserEntity;
import com.example.module_javaspringboot_day11.modal.UserModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity,Long> {
}
