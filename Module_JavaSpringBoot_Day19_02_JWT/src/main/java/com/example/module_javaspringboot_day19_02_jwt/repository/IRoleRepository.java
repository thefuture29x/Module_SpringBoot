package com.example.module_javaspringboot_day19_02_jwt.repository;

import com.example.module_javaspringboot_day19_02_jwt.entities.RoleEntity;
import com.example.module_javaspringboot_day19_02_jwt.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {

}
