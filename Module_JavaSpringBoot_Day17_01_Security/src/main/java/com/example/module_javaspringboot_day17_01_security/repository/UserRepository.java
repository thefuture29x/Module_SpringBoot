package com.example.module_javaspringboot_day17_01_security.repository;

import com.example.module_javaspringboot_day17_01_security.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);

    @Query(value = "UPDATE user SET failed_attempt = :failAttempts WHERE username = :username",nativeQuery = true)
    @Transactional
    @Modifying
    void updateFailedAttempts(@Param("failAttempts") int failAttempts,
                              @Param("username") String username);

}
