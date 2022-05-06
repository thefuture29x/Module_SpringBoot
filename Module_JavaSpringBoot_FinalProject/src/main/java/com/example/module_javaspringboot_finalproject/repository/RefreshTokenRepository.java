package com.example.module_javaspringboot_finalproject.repository;

import com.example.module_javaspringboot_finalproject.entities.CategoryEntity;
import com.example.module_javaspringboot_finalproject.entities.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity,Long> {
}
