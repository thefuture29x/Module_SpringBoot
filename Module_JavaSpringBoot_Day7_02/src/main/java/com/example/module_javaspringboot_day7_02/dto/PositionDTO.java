package com.example.module_javaspringboot_day7_02.dto;


public class PositionDTO {
    private int id;
    private String name;
    private String cfc_salary;
    private int a_days_wages;

    public PositionDTO() {
    }

    public int getA_days_wages() {
        return a_days_wages;
    }

    public void setA_days_wages(int a_days_wages) {
        this.a_days_wages = a_days_wages;
    }

    public PositionDTO(int id, String name, String cfc_salary, int a_days_wages) {
        this.id = id;
        this.name = name;
        this.cfc_salary = cfc_salary;
        this.a_days_wages = a_days_wages;
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
