package com.example.module_javaspringboot_day4.data;

import com.example.module_javaspringboot_day4.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserDATA {

    public ArrayList<UserDTO> createUserData(){
        ArrayList<UserDTO> data = new ArrayList<>();

        data.add(new UserDTO(1,"admin","12345678","ROLE_ADMIN"));
        data.add(new UserDTO(2,"Phong","12345678","ROLE_USER"));
        data.add(new UserDTO(3,"Long","12345678","ROLE_USER"));

        return data;
    }
}
