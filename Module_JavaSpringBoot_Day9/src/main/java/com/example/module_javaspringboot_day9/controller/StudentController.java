package com.example.module_javaspringboot_day9.controller;

import com.example.module_javaspringboot_day9.convert.SubjectConvert;
import com.example.module_javaspringboot_day9.dto.*;
import com.example.module_javaspringboot_day9.entities.StudentEntity;
import com.example.module_javaspringboot_day9.entities.SubjectEntity;
import com.example.module_javaspringboot_day9.repository.IStudentRepository;
import com.example.module_javaspringboot_day9.service.*;
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

        model.addAttribute("listSubject",iTimeTableService.getListSubject());
        model.addAttribute("timetable",iTimeTableService.findAllByIdStudent(1L));
        return "time_table";
    }
    @GetMapping("/regist-subject")
    public String getListSubject(Model model){
        model.addAttribute("listRegist",iRegistSubjectService.findListSubjectNoneRegist(1L));
        return "regist_subject";
    }
    @PostMapping("/regist-subject")
    public String registSubject(Model model,@RequestParam(name = "id_subject") int id_subject){
        RegistSubjectDTO registSubjectDTO = iRegistSubjectService.findById((long) id_subject);
        TimeTableDTO timeTableDTO = new TimeTableDTO();
        timeTableDTO.setId(null);
        timeTableDTO.setName(registSubjectDTO.getName());
        timeTableDTO.setTime(registSubjectDTO.getTime());
        timeTableDTO.setStatus("In Process");
        timeTableDTO.setId_timeTable(1L);
        iTimeTableService.saveOrUpdate(timeTableDTO);

        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setId(null);
        scoreDTO.setProcessScore(0);
        scoreDTO.setFinalScore(0);
        scoreDTO.setTestScore(0);
        scoreDTO.setId_student(1L);
        Long newIdScore = iScoreService.saveOrUpdate(scoreDTO);

        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(null);
        subjectDTO.setName(registSubjectDTO.getName());
        subjectDTO.setTime(registSubjectDTO.getTime());
        subjectDTO.setId_score(newIdScore);

        StudentEntity studentEntity = iStudentRepository.getById(1L);
        List<SubjectEntity> listSubject = new ArrayList<>();
        listSubject.add(subjectConvert.toEntity(iSubjectService.saveOrUpdate(subjectDTO)));
        studentEntity.setListSubject(listSubject);
        iStudentRepository.save(studentEntity);

        return "redirect:regist-subject";


    }


}
