package com.example.module_javaspringboot_finalproject.service;

import com.example.module_javaspringboot_finalproject.dto.UserDTO;
import com.example.module_javaspringboot_finalproject.entities.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserDTO> findAllUser();
    UserDTO enabledUser(Long id_user);
    void saveUser(UserDTO userDTO);
    void downloadImage(String url,String fileLocalPath);
    void updateUserToken(String email,String token);
    UserEntity findUserByToken(String token);
    UserEntity findByEmail(String email);
}
