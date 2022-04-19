package com.example.module_javaspringboot_day14.controller;

import com.example.module_javaspringboot_day14.service.AdminService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/product")
    public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
        ExecutionResult execute = adminService.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
