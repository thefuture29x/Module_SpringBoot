package com.example.module_javaspringboot_day19_02_jwt.controller;

import com.example.module_javaspringboot_day19_02_jwt.entities.RefreshTokenEntity;
import com.example.module_javaspringboot_day19_02_jwt.entities.RoleEntity;
import com.example.module_javaspringboot_day19_02_jwt.entities.UserEntity;
import com.example.module_javaspringboot_day19_02_jwt.jwt.JwtTokenProvider;
import com.example.module_javaspringboot_day19_02_jwt.payload.request.LoginRequest;
import com.example.module_javaspringboot_day19_02_jwt.payload.request.RefreshTokenRequest;
import com.example.module_javaspringboot_day19_02_jwt.payload.response.LoginResponse;
import com.example.module_javaspringboot_day19_02_jwt.payload.response.RefreshTokenResponse;
import com.example.module_javaspringboot_day19_02_jwt.repository.IRoleRepository;
import com.example.module_javaspringboot_day19_02_jwt.repository.IUserRepository;
import com.example.module_javaspringboot_day19_02_jwt.service.RefreshTokenService;
import com.example.module_javaspringboot_day19_02_jwt.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class HomeController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    IRoleRepository iRoleRepository;
    @Autowired
    RefreshTokenService refreshTokenService;


    @GetMapping("/test")
    public String getTest(){
        return "Test Content";
    }

    @PostMapping("/login")
    public LoginResponse getResponseAfterLogin(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtTokenProvider.generateTokenFormUserName(userDetails.getUsername());
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        RefreshTokenEntity refreshTokenEntity = refreshTokenService.createRefreshToken(userDetails.getUserEntity().getId());
        return LoginResponse.builder()
                .id(userDetails.getUserEntity().getId())
                .username(userDetails.getUsername())
                .accessToken(jwtToken)
                .tokenType(new LoginResponse().getTokenType())
                .role(roles)
                .refreshToken(refreshTokenEntity.getRefreshToken())
                .build();
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> createRefreshToken(@RequestBody RefreshTokenRequest request){
        RefreshTokenEntity refreshTokenEntity = refreshTokenService.findByRefreshToken(request.getRefreshToken());
        RefreshTokenEntity refreshTokenVerifyExpiration = refreshTokenService.verifyExpiration(refreshTokenEntity);
        UserEntity userEntity = refreshTokenVerifyExpiration.getUserEntity();
        String token = jwtTokenProvider.generateTokenFormUserName(userEntity.getUsername());
        return ResponseEntity.ok().body(new RefreshTokenResponse(token,request.getRefreshToken()));
    }

    @GetMapping("/add")
    public String addNewUser(){
        RoleEntity roleAdmin = iRoleRepository.getById(1L);
        RoleEntity roleUser = iRoleRepository.getById(2L);
        RoleEntity roleMentor = iRoleRepository.getById(3L);
        List<RoleEntity> listRoleAdmin = new ArrayList<>();
        listRoleAdmin.add(roleAdmin);
        List<RoleEntity> listRoleUser = new ArrayList<>();
        listRoleUser.add(roleUser);
        List<RoleEntity> listRoleMentor = new ArrayList<>();
        listRoleMentor.add(roleMentor);
//        iUserRepository.save(new UserEntity(null,"admin",passwordEncoder.encode("123456"),listRoleAdmin));
//        iUserRepository.save(new UserEntity(null,"user",passwordEncoder.encode("123456"),listRoleUser));
//        iUserRepository.save(new UserEntity(null,"mentor",passwordEncoder.encode("123456"),listRoleMentor));
        return null;
    }




}
