package com.example.module_javaspringboot_day5_02.service;


import com.example.module_javaspringboot_day5_02.dto.UserDTO;

import java.util.Optional;

public interface IUserService {
    UserDTO checkInforUser(String username, String password);
    UserDTO findByName(String username);
    Optional<UserDTO> findById(Integer id);
}
