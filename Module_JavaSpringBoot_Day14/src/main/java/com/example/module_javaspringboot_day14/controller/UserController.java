package com.example.module_javaspringboot_day14.controller;

import com.example.module_javaspringboot_day14.service.AdminService;
import com.example.module_javaspringboot_day14.service.UserService;
import graphql.ExecutionResult;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/product")
    public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
        ExecutionResult execute = userService.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }

}
