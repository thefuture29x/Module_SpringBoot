package com.example.module_javaspringboot_day7_02.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "empDepartment", cascade = CascadeType.PERSIST)
    private List<EmployeeEntity> listEmp;

    public DepartmentEntity() {
    }

    public DepartmentEntity(int id, String name, List<EmployeeEntity> listEmp) {
        this.id = id;
        this.name = name;
        this.listEmp = listEmp;
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

    public List<EmployeeEntity> getListEmp() {
        return listEmp;
    }

    public void setListEmp(List<EmployeeEntity> listEmp) {
        this.listEmp = listEmp;
    }

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listEmp=" + listEmp +
                '}';
    }
}
