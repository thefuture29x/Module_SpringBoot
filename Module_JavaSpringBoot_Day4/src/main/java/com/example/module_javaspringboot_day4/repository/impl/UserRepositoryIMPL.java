package com.example.module_javaspringboot_day4.repository.impl;

import com.example.module_javaspringboot_day4.data.UserDATA;
import com.example.module_javaspringboot_day4.dto.UserDTO;
import com.example.module_javaspringboot_day4.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepositoryIMPL implements IUserRepository {
    final UserDATA userDATA;

    ArrayList<UserDTO> listUser;
    @Autowired
    ProductRepositoryIMPL productRepositoryIMPL ;



    public UserRepositoryIMPL(UserDATA userDATA) {
        this.userDATA = userDATA;
        listUser = this.userDATA.createUserData();
    }

    @Override
    public UserDTO checkInforUser(String username, String password) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)){
                if (listUser.get(i).getPassword().equals(password)){
                    return listUser.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public UserDTO findByName(String username) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)){
                return listUser.get(i);
            }
        }
        return null;
    }

    @Override
    public UserDTO findById(Integer id) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getId() == id){
                return listUser.get(i);
            }
        }
        return null;
    }
}
