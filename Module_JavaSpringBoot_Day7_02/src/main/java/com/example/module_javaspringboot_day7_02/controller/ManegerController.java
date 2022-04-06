package com.example.module_javaspringboot_day7_02.controller;

import com.example.module_javaspringboot_day7_02.convert.DepartmentConvert;
import com.example.module_javaspringboot_day7_02.convert.EmployeeConvert;
import com.example.module_javaspringboot_day7_02.convert.PositionConvert;
import com.example.module_javaspringboot_day7_02.dao.DepartmentDAO;
import com.example.module_javaspringboot_day7_02.dao.EmployeeDAO;
import com.example.module_javaspringboot_day7_02.dao.LogWorkDAO;
import com.example.module_javaspringboot_day7_02.dao.PositionDAO;
import com.example.module_javaspringboot_day7_02.dto.DepartmentDTO;
import com.example.module_javaspringboot_day7_02.dto.EmployeeDTO;
import com.example.module_javaspringboot_day7_02.entities.DepartmentEntity;
import com.example.module_javaspringboot_day7_02.entities.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.beans.Beans;
import java.util.List;

@Controller
public class ManegerController {
    EmployeeDAO employeeDAO = new EmployeeDAO();
    DepartmentDAO departmentDAO = new DepartmentDAO();
    PositionDAO positionDAO = new PositionDAO();
    LogWorkDAO logWorkDAO = new LogWorkDAO();
    EmployeeConvert convert = new EmployeeConvert();
    DepartmentConvert convertDP = new DepartmentConvert();
    PositionConvert convertPS = new PositionConvert();

    @GetMapping("/home")
    public String getManegerPage(Model model){
        model.addAttribute("listEmployee",employeeDAO.getAll());
//        model.addAttribute("empDepartment",departmentDAO.findById());
        return "list_employee";
    }
    @PostMapping("/edit-empl")
    public String getCreateNewEmplForm(Model model, @RequestParam(value = "id_empl") int id){
        if (id == 0){
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setDepartment(convertDP.toEntity(departmentDAO.findById(1)));
            employeeDTO.setPosition(convertPS.toEntity(positionDAO.findById(1)));
            model.addAttribute("employeeEdit",employeeDTO);
        }else {
            model.addAttribute("employeeEdit",employeeDAO.findById(id));
        }
        model.addAttribute("listDepartment",departmentDAO.getAll());
        model.addAttribute("listPosition",positionDAO.getAll());
        return "edit_empl";
    }

    @PostMapping("/save-update")
    public String saveOrUpdateEmploy(Model model, EmployeeDTO employee){
        employeeDAO.saveOrUpdate(employee);
        return "redirect:home";
    }
    @PostMapping("/delete-empl")
    public String deleteEmployee(Model model, @RequestParam(value = "id_empl") int id){
        employeeDAO.delete(employeeDAO.findById(id));
        return "redirect:home";
    }
    @PostMapping("/logwork-empl")
    public String getLogWorkEmployee(Model model, @RequestParam(value = "id_empl") int id){
        model.addAttribute("listLogWork",logWorkDAO.getLogWorkOfEmpl(id));
        return "logwork";
    }

}
