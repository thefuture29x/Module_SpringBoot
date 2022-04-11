package com.example.module_javaspringboot_day9_02.controller;

import com.example.module_javaspringboot_day9_02.convert.*;
import com.example.module_javaspringboot_day9_02.dto.*;
import com.example.module_javaspringboot_day9_02.entities.*;
import com.example.module_javaspringboot_day9_02.repository.*;
import com.example.module_javaspringboot_day9_02.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    IStudentService iStudentService;
    @Autowired
    ISubjectService iSubjectService;
    @Autowired
    IRegistSubjectService iRegistSubjectService;
    @Autowired
    ITimeTableService iTimeTableService;
    @Autowired
    IScoreService iScoreService;
    @Autowired
    IStudentRepository iStudentRepository;
    @Autowired
    SubjectConvert subjectConvert;

    @GetMapping("/home")
    public String getHomePage(Model model){
//        iTimeTableService.getListSubject();
        return "home";
    }
    @GetMapping("/infor")
    public String getInforStudent(Model model){
        model.addAttribute("studentObject",iStudentService.findById(1L));
        return "infor_student";
    }
    @GetMapping("/time-table")
    public String getTimeTable(Model model){
        model.addAttribute("timetable",iTimeTableService.findAllByIdStudent(1L));
        return "time_table";
    }
    @GetMapping("/regist-subject")
    public String getListSubject(Model model){
//        model.addAttribute("listRegist",iRegistSubjectService.findAll());
        model.addAttribute("listRegist",iRegistSubjectService.findListSubjectNoneRegist(1L));
        return "regist_subject";
    }
    @PostMapping("/regist-subject")
    public String registSubject(Model model,@RequestParam(name = "id_subject") int id_subject){
        iRegistSubjectService.studentRegistSubject(1L,(long) id_subject);
        return "redirect:regist-subject";
    }


}
