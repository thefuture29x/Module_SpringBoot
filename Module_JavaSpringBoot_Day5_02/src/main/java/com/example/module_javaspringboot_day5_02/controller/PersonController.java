package com.example.module_javaspringboot_day5_02.controller;

import com.example.module_javaspringboot_day5_02.dto.PersonDTO;
import com.example.module_javaspringboot_day5_02.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/get-person")
    public String homePage(){
        List<PersonDTO> dtoList = (List<PersonDTO>) personRepository.findAll();
        for (PersonDTO persons :
                dtoList) {
            System.out.println(persons.toString());
        }
        return "index";
    }
    @GetMapping("/save-person")
    public String savePerson(){
        personRepository.save(new PersonDTO(0,"Phong","Ha Noi"));

        return "index";
    }
}
