package com.example.module_javaspringboot_day21_01_sendmailresetpassword.service.impl;

import com.example.module_javaspringboot_day21_01_sendmailresetpassword.entities.UserEntity;
import com.example.module_javaspringboot_day21_01_sendmailresetpassword.repository.IUserRepository;
import com.example.module_javaspringboot_day21_01_sendmailresetpassword.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public void saveUser(UserEntity userEntity){
        iUserRepository.save(userEntity);
    }

    @Override
    public void updateUserToken(String email, String token) {
        UserEntity userEntity = iUserRepository.findByEmail(email);
        userEntity.setResetPassWordToken(token);
        iUserRepository.save(userEntity);
    }

    @Override
    public UserEntity findUserByToken(String token) {
        return iUserRepository.findByResetPassWordToken(token);
    }
}
