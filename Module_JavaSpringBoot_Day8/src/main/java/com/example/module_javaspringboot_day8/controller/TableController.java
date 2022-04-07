package com.example.module_javaspringboot_day8.controller;

import com.example.module_javaspringboot_day8.convert.UserConvert;
import com.example.module_javaspringboot_day8.dto.TableDTO;
import com.example.module_javaspringboot_day8.dto.TimeBookTableDTO;
import com.example.module_javaspringboot_day8.dto.UserDTO;
import com.example.module_javaspringboot_day8.entities.TableEntity;
import com.example.module_javaspringboot_day8.entities.UserEntity;
import com.example.module_javaspringboot_day8.repository.TimeBookTableRepository;
import com.example.module_javaspringboot_day8.service.ITableService;
import com.example.module_javaspringboot_day8.service.IUserService;
import com.example.module_javaspringboot_day8.service.impl.TableServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class TableController {
    @Autowired
    ITableService iTableService;
    @Autowired
    IUserService userService;
    @Autowired
    UserConvert userConvert;
    @Autowired
    TimeBookTableRepository tableRepository;

    @GetMapping("/home")
    public String getHomePage(Model model){
        model.addAttribute("listTable",iTableService.findAll());
        return "home";
    }

    @PostMapping("/book-table")
    public String bookTable(Model model,@RequestParam(name = "id_table") Long id){
        model.addAttribute("Table",iTableService.findById(id));
        model.addAttribute("timeBook",new TimeBookTableDTO());
        return "reservation";
    }
    @PostMapping("/checkout")
    public String checkout(Model model, TableDTO tableDTO){
//        TableDTO tableDTO = iTableService.findById((long) id);

        tableDTO.setStatus("Reservations");
//        iTableService.saveOrUpdate(tableDTO);
        return "redirect:home";
    }

}
