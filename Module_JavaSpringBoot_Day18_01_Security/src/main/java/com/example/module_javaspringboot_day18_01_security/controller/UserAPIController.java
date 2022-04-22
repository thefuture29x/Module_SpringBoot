package com.example.module_javaspringboot_day18_01_security.controller;

import com.example.module_javaspringboot_day18_01_security.entities.RoleEntity;
import com.example.module_javaspringboot_day18_01_security.entities.UserEntity;
import com.example.module_javaspringboot_day18_01_security.repository.IRoleRepository;
import com.example.module_javaspringboot_day18_01_security.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAPIController {
    @Autowired
    IRoleRepository iRoleRepository;


    @GetMapping("/get-permission")
    public RoleEntity getPermission2(@RequestParam("role") String role_name){
        RoleEntity roleEntity = iRoleRepository.findByRole(role_name);
        return roleEntity;
    }
}
