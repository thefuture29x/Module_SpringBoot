package com.example.module_javaspringboot_day9.controller;

import com.example.module_javaspringboot_day9.dto.StudentDTO;
import com.example.module_javaspringboot_day9.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {
    @Autowired
    IStudentService iStudentService;

    @GetMapping("/list-student")
    public String getListStudent(Model model){
        model.addAttribute("listStudent",iStudentService.findAll());
        return "list_student";
    }

    @PostMapping("/edit-student")
    public String editStudent(Model model, @RequestParam(name = "id_student") int id_student){
        if (id_student == 0){
            model.addAttribute("studentObject",new StudentDTO());
        }else{
            model.addAttribute("studentObject",iStudentService.findById((long) id_student));
        }
        return "edit_student";
    }

    @PostMapping("/save-student")
    public String saveOrUpdate(Model model, StudentDTO studentDTO){
        iStudentService.saveOrUpdate(studentDTO);
        return "redirect:list-student";
    }
    @PostMapping("/delete-student")
    public String delete(@RequestParam(name = "id_student") int id_student){
        iStudentService.delete((long) id_student);
        return "redirect:list-student";
    }
    @GetMapping("/get-student-score")
    public String getScoreStudent(@RequestParam(name = "id_student") int id_student,Model model){
        model.addAttribute("studentObject",iStudentService.findById((long) id_student));
        return "student-score";
    }
}
