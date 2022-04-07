package com.example.module_javaspringboot_day7_02.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "position")
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String cfc_salary;
    private int a_days_wages;

    @OneToMany(mappedBy = "empPosition",cascade = CascadeType.PERSIST)
    private List<EmployeeEntity> listEmployee;


    public PositionEntity() {
    }

    public PositionEntity(int id, String name, String cfc_salary, int a_days_wages, List<EmployeeEntity> listEmployee) {
        this.id = id;
        this.name = name;
        this.cfc_salary = cfc_salary;
        this.a_days_wages = a_days_wages;
        this.listEmployee = listEmployee;
    }

    public int getA_days_wages() {
        return a_days_wages;
    }

    public void setA_days_wages(int a_days_wages) {
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

    public List<EmployeeEntity> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<EmployeeEntity> listEmployee) {
        this.listEmployee = listEmployee;
    }

    @Override
    public String toString() {
        return "PositionEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cfc_salary='" + cfc_salary + '\'' +
                ", listEmployee=" + listEmployee +
                '}';
    }
}
