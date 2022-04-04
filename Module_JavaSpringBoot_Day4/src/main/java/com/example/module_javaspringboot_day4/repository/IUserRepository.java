package com.example.module_javaspringboot_day4.repository;

import com.example.module_javaspringboot_day4.dto.UserDTO;

public interface IUserRepository {
    UserDTO checkInforUser(String username, String password);
    UserDTO findByName(String username);
    UserDTO findById(Integer id);
}
