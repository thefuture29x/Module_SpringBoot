package com.example.module_javaspringboot_day19_02_jwt.repository;

import com.example.module_javaspringboot_day19_02_jwt.entities.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRefreshTokenRepository extends JpaRepository<RefreshTokenEntity,Long> {
    RefreshTokenEntity findByRefreshToken(String refreshToken);
}
