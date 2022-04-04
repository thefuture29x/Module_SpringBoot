package com.example.module_javaspringboot_day4.service;

import com.example.module_javaspringboot_day4.dto.UserDTO;

public interface IUserService {
    UserDTO checkInforUser(String username, String password);
    UserDTO findByName(String username);
    UserDTO findById(Integer id);
}
