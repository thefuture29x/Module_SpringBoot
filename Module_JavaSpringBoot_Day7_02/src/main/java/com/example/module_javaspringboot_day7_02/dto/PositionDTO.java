package com.example.module_javaspringboot_day7_02.dto;


public class PositionDTO {
    private int id;
    private String name;
    private String cfc_salary;

    public PositionDTO() {
    }

    public PositionDTO(int id, String name, String cfc_salary) {
        this.id = id;
        this.name = name;
        this.cfc_salary = cfc_salary;
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

    public String getCfc_salary() {
        return cfc_salary;
    }

    public void setCfc_salary(String cfc_salary) {
        this.cfc_salary = cfc_salary;
    }
}
