package com.example.module_javaspringboot_day8.service;

import com.example.module_javaspringboot_day8.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> findAll();
    void saveOrUpdate(UserDTO UserDTO);
    UserDTO  findById(Long id);
    Long[] delete(Long[] id);
}
