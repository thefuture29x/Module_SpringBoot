package com.example.module_javaspringboot_day12.controller;

import com.example.module_javaspringboot_day12.dto.InformationDTO;
import com.example.module_javaspringboot_day12.repository.IInformationRepository;
import com.example.module_javaspringboot_day12.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class InformationController {
    @Autowired
    InformationService informationService;

    @GetMapping("/getall")
    public List<InformationDTO> getAll(){
        return informationService.getInformation();
    }

}
