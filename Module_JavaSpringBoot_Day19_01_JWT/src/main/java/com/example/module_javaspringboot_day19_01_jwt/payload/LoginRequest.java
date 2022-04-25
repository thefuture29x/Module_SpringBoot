package com.example.module_javaspringboot_day19_01_jwt.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class LoginRequest {

    private String username;
    private String password;
}
