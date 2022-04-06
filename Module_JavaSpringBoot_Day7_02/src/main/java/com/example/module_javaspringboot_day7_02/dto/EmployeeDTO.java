package com.example.module_javaspringboot_day7_02.dto;


import com.example.module_javaspringboot_day7_02.entities.DepartmentEntity;
import com.example.module_javaspringboot_day7_02.entities.LogWorkEntity;
import com.example.module_javaspringboot_day7_02.entities.PositionEntity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EmployeeDTO {
    private int id;
    private String name;
    private String phone;
    private String address;
    private int id_post;
    private int id_depart;
    private DepartmentEntity department;
    private PositionEntity position;
    private LogWorkEntity logwork;

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public PositionEntity getPosition() {
        return position;
    }

    public void setPosition(PositionEntity position) {
        this.position = position;
    }

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id_post, int id_depart) {
        this.id_post = id_post;
        this.id_depart = id_depart;
    }

    public EmployeeDTO(int id, String name, String phone, String address, int id_post, int id_depart, DepartmentEntity department, PositionEntity position, LogWorkEntity logwork) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.id_post = id_post;
        this.id_depart = id_depart;
        this.department = department;
        this.position = position;
        this.logwork = logwork;
    }

    public LogWorkEntity getLogwork() {
        return logwork;
    }

    public void setLogwork(LogWorkEntity logwork) {
        this.logwork = logwork;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public int getId_depart() {
        return id_depart;
    }

    public void setId_depart(int id_depart) {
        this.id_depart = id_depart;
    }
}
