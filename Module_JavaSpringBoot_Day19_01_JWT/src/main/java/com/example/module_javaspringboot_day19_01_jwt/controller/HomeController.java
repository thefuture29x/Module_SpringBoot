package com.example.module_javaspringboot_day19_01_jwt.controller;

import com.example.module_javaspringboot_day19_01_jwt.entities.UserEntity;
import com.example.module_javaspringboot_day19_01_jwt.jwt.JwtTokenProvider;
import com.example.module_javaspringboot_day19_01_jwt.payload.LoginRequest;
import com.example.module_javaspringboot_day19_01_jwt.payload.LoginResponse;
import com.example.module_javaspringboot_day19_01_jwt.repository.IUserRepository;
import com.example.module_javaspringboot_day19_01_jwt.service.CustomerUserDetails;
import com.example.module_javaspringboot_day19_01_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authen")
public class HomeController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    IUserRepository iUserRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword())
        );
        CustomerUserDetails customerUserDetails = (CustomerUserDetails) authentication.getPrincipal();
        String jwt= jwtTokenProvider.generateToken(customerUserDetails);
        return ResponseEntity.ok(jwt);
    }

    @GetMapping("/add")
    public String addNewAccount(){
        UserEntity userEntity = new UserEntity(null,"haiphong",passwordEncoder.encode("123456"));
        return iUserRepository.save(userEntity).toString();
    }
}
