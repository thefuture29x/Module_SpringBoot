package com.example.module_javaspringboot_day7_02.dto;

public class SalaryDTO {
    private int id;
    private int cfc_salary;
    private int work_hour;
    private int a_days_wages;

    public SalaryDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCfc_salary() {
        return cfc_salary;
    }

    public void setCfc_salary(int cfc_salary) {
        this.cfc_salary = cfc_salary;
    }

    public int getWork_hour() {
        return work_hour;
    }

    public void setWork_hour(int work_hour) {
        this.work_hour = work_hour;
    }

    public int getA_days_wages() {
        return a_days_wages;
    }

    public void setA_days_wages(int a_days_wages) {
        this.a_days_wages = a_days_wages;
    }

    public SalaryDTO(int id, int cfc_salary, int work_hour, int a_days_wages) {
        this.id = id;
        this.cfc_salary = cfc_salary;
        this.work_hour = work_hour;
        this.a_days_wages = a_days_wages;
    }
}
