package com.example.module_javaspringboot_day4.service.impl;

import com.example.module_javaspringboot_day4.dto.UserDTO;
import com.example.module_javaspringboot_day4.repository.IUserRepository;
import com.example.module_javaspringboot_day4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements IUserService {
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public UserDTO checkInforUser(String username, String password) {
        return iUserRepository.checkInforUser(username,password);
    }

    @Override
    public UserDTO findByName(String username) {
        return iUserRepository.findByName(username);
    }

    @Override
    public UserDTO findById(Integer id) {
        return iUserRepository.findById(id);
    }
}
