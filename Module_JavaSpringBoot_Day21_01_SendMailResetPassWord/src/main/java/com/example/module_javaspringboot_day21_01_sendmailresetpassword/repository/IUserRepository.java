package com.example.module_javaspringboot_day21_01_sendmailresetpassword.repository;

import com.example.module_javaspringboot_day21_01_sendmailresetpassword.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByResetPassWordToken(String token);
    UserEntity findByEmail(String email);
}
