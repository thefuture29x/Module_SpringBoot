package com.example.module_javaspringboot_day21_01_sendmailresetpassword.service;

import com.example.module_javaspringboot_day21_01_sendmailresetpassword.entities.UserEntity;

public interface IUserService {
    void saveUser(UserEntity userEntity);
    void updateUserToken(String email,String token);
    UserEntity findUserByToken(String token);
}
