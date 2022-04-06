package com.example.module_javaspringboot_day7_02.dto;

import com.example.module_javaspringboot_day7_02.entities.EmployeeEntity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class LogWorkDTO {
    private int id;
    private Date date_start;
    private String description;
    private int work_hours;
    private EmployeeEntity emp_logwork;

    public LogWorkDTO() {
    }

    public LogWorkDTO(int id, Date date_start, String description, int work_hours, EmployeeEntity emp_logwork) {
        this.id = id;
        this.date_start = date_start;
        this.description = description;
        this.work_hours = work_hours;
        this.emp_logwork = emp_logwork;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWork_hours() {
        return work_hours;
    }

    public void setWork_hours(int work_hours) {
        this.work_hours = work_hours;
    }

    public EmployeeEntity getEmp_logwork() {
        return emp_logwork;
    }

    public void setEmp_logwork(EmployeeEntity emp_logwork) {
        this.emp_logwork = emp_logwork;
    }
}
