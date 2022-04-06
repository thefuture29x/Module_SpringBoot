package com.example.module_javaspringboot_day7_02.controller;

import com.example.module_javaspringboot_day7_02.convert.EmployeeConvert;
import com.example.module_javaspringboot_day7_02.dao.EmployeeDAO;
import com.example.module_javaspringboot_day7_02.dao.LogWorkDAO;
import com.example.module_javaspringboot_day7_02.dto.LogWorkDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    LogWorkDAO logWorkDAO = new LogWorkDAO();
    EmployeeDAO employeeDAO = new EmployeeDAO();
    EmployeeConvert convert = new EmployeeConvert();
    @GetMapping("/timekeeping")
    public String getEmplPage(Model model){
        model.addAttribute("logWork",new LogWorkDTO());
        return "timekeeping";
    }
    @PostMapping("/save-logwork")
    public String saveLogWork(LogWorkDTO logwrok){
        logwrok.setEmp_logwork(convert.toEntity(employeeDAO.findById(1)));
        logWorkDAO.saveOrUpdate(logwrok);
        return "redirect:timekeeping";
    }

}
