package com.example.module_javaspingboot_day16_02_practicejpa.controller;

import com.example.module_javaspingboot_day16_02_practicejpa.repository.ICustomerRepository;
import com.example.module_javaspingboot_day16_02_practicejpa.specification.CustomerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @GetMapping("/get-customer/{id}/{name}")
    public ResponseEntity<?> getCustommerByID(@PathVariable("id") int id,@PathVariable("name") String name){
        Specification specification = Specification
                .where(CustomerSpecification.hasId((long) id))
                .and(CustomerSpecification.hasNameEqual(name));
        return ResponseEntity.ok().body(iCustomerRepository.findAll(specification));
    }

    @PostMapping("/get-customer-name-equal")
    public ResponseEntity<?> getCustommerByNameEqual(@RequestBody String name){
        Specification specification = Specification.where(CustomerSpecification.hasNameEqual(name));
        return ResponseEntity.ok().body(iCustomerRepository.findAll(specification));
    }

    @PostMapping("/get-customer-name-like")
    public ResponseEntity<?> getCustommerByNameLike(@RequestBody String name){
        Specification specification = Specification.where(CustomerSpecification.hasNameLike(name));
        return ResponseEntity.ok().body(iCustomerRepository.findAll(specification));
    }
}
