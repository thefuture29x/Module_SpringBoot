package com.example.module_javaspringboot_day5_02.service.impl;

import com.example.module_javaspringboot_day5_02.dto.UserDTO;
import com.example.module_javaspringboot_day5_02.repository.IUserRepository;
import com.example.module_javaspringboot_day5_02.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Optional<UserDTO> findById(Integer id) {
        return iUserRepository.findById(id);
    }
}
