package com.example.module_javaspringboot_day19_02_jwt.service;

import com.example.module_javaspringboot_day19_02_jwt.entities.RefreshTokenEntity;
import com.example.module_javaspringboot_day19_02_jwt.repository.IRefreshTokenRepository;
import com.example.module_javaspringboot_day19_02_jwt.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {
    @Value("${bezkoder.app.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;
    @Autowired
    private IRefreshTokenRepository iRefreshTokenRepository;
    @Autowired
    IUserRepository iUserRepository;

    public RefreshTokenEntity findByRefreshToken(String refreshToken){
        return iRefreshTokenRepository.findByRefreshToken(refreshToken);
    }

    public RefreshTokenEntity createRefreshToken(Long id_user){
        RefreshTokenEntity refreshTokenEntity = new RefreshTokenEntity();
        refreshTokenEntity.setId(null);
        refreshTokenEntity.setUserEntity(iUserRepository.getById(id_user));
        refreshTokenEntity.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshTokenEntity.setRefreshToken(UUID.randomUUID().toString());

        return iRefreshTokenRepository.save(refreshTokenEntity);
    }

    public RefreshTokenEntity verifyExpiration(RefreshTokenEntity token){
        if (token.getExpiryDate().compareTo(Instant.now()) < 0){
            iRefreshTokenRepository.delete(token);
        }
        return token;
    }



}
