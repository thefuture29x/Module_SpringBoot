package com.example.module_javaspringboot_day22_01_practice.service;

import com.example.module_javaspringboot_day22_01_practice.entities.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserEntity> findAllUser();
    void saveUser(UserEntity userEntity);
    void updateUserToken(String email,String token);
    UserEntity findUserByToken(String token);
    UserEntity findByEmail(String email);
}
