package com.example.module_javaspringboot_day5_02.controller;

import com.example.module_javaspringboot_day5_02.dto.PersonDTO;
import com.example.module_javaspringboot_day5_02.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/findall-person")
    public String homePage(Model model,@RequestParam("page") int page, @RequestParam("limit") int limit){
        Pageable pageable = PageRequest.of(1 -1,3);


//        Page<PersonDTO> dtoList =  personRepository.findAll(1,5);
//        List<PersonDTO> dtoList = (List<PersonDTO>) personRepository.findAll(pageable);
//        List<PersonDTO> dtoList = (List<PersonDTO>) personRepository.findAll();
//        model.addAttribute("ListPerson",dtoList);
        return "index";
    }

    @PostMapping("/save-person")
    public String savePerson(PersonDTO personDTO){
        personRepository.save(personDTO);
        return "redirect:findall-person";
    }

    @GetMapping("/edit-person")
    public String savePerson(@RequestParam(value = "id") int id,Model model){
        if (id == 0){
            model.addAttribute("Person",new PersonDTO());
        }else {
            model.addAttribute("Person",personRepository.findById(id));
        }
        return "edit_person";
    }
    @GetMapping("/delete-person")
    public String deletePerson(@RequestParam(value = "id") int id){
        personRepository.deleteById(id);
        return "redirect:findall-person";
    }
}
