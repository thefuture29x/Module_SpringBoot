package com.example.module_javaspringboot_day7_02.dto;

public class DepartmentDTO {
    private int id;
    private String name;

    public DepartmentDTO() {
    }

    public DepartmentDTO(int id, String name) {
        this.id = id;
        this.name = name;
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
}
