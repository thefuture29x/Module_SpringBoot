package com.example.module_javaspringboot_day11.service.impl;

import com.example.module_javaspringboot_day11.modal.UserModal;
import com.example.module_javaspringboot_day11.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceIMPL implements IUserService {
    @Override
    public List<UserModal> findAll() {
        return null;
    }

    @Override
    public boolean save(UserModal userModal) {
        return false;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public UserModal findById(Long aLong) {
        return null;
    }
}
