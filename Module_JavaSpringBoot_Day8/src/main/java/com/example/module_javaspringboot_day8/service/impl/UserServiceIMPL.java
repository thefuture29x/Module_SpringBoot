package com.example.module_javaspringboot_day8.service.impl;

import com.example.module_javaspringboot_day8.convert.UserConvert;
import com.example.module_javaspringboot_day8.dto.UserDTO;
import com.example.module_javaspringboot_day8.entities.UserEntity;
import com.example.module_javaspringboot_day8.repository.UserRepository;
import com.example.module_javaspringboot_day8.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements IUserService {
    @Autowired
    UserRepository UserRepository;
    @Autowired
    UserConvert UserConvert;

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> dtoList = new ArrayList<>();
        for (UserEntity entity: UserRepository.findAll()) {
            dtoList.add(UserConvert.toDTO(entity));
        }
        return dtoList;
    }

    @Override
    public void saveOrUpdate(UserDTO UserDTO) {
        if (UserDTO.getId() == null){
            UserRepository.save(UserConvert.toEntity(UserDTO));
        }else {
            UserEntity oldEntity = UserRepository.getById(UserDTO.getId());
            UserEntity newEntity = UserConvert.toEntity(oldEntity,UserDTO);
            UserRepository.save(newEntity);
        }
    }

    @Override
    public UserDTO findById(Long id) {
        return UserConvert.toDTO(UserRepository.getById(id));
    }

    @Override
    public Long[] delete(Long[] id) {
        for (int i = 0; i < id.length; i++) {
            UserRepository.deleteById(id[i]);
        }
        return id;
    }

    public static void main(String[] args) {

    }
}
