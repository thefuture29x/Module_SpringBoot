package com.example.module_javaspringboot_day9_02.controller;

import com.example.module_javaspringboot_day9_02.dto.ScoreDTO;
import com.example.module_javaspringboot_day9_02.dto.StudentDTO;
import com.example.module_javaspringboot_day9_02.service.IScoreService;
import com.example.module_javaspringboot_day9_02.service.IStudentService;
import com.example.module_javaspringboot_day9_02.service.ITimeTableService;
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
    @Autowired
    IScoreService iScoreService;
    @Autowired
    ITimeTableService iTimeTableService;

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
        model.addAttribute("timetable",iTimeTableService.findAllByIdStudent((long) id_student));
        return "student-score";
    }

    @PostMapping("/set-student-score")
    public String setScoreStudent(@RequestParam(name = "id_score") int id_score,
                                  @RequestParam(name = "sc_process") int sc_process,
                                  @RequestParam(name = "sc_test") int sc_test,
                                  @RequestParam(name = "sc_final") int sc_final){
        ScoreDTO scoreDTO = iScoreService.findById((long) id_score);
        scoreDTO.setProcessScore(sc_process);
        scoreDTO.setTestScore(sc_test);
        scoreDTO.setFinalScore(sc_final);
        iScoreService.saveOrUpdate(scoreDTO);
        return "redirect:get-student-score?id_student=1";
    }
}
