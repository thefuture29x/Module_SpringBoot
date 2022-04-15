package com.example.module_javaspringboot_day13.controller;

import com.example.module_javaspringboot_day13.service.MainService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    MainService mainService;


    @PostMapping("/getAll")
    public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
        ExecutionResult execute = mainService.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
