package com.example.module_javaspringboot_day7_02.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String address;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "emp_position")
    private PositionEntity empPosition;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "emp_department")
    private DepartmentEntity empDepartment;

    @OneToMany(mappedBy = "emp_logwork", cascade = CascadeType.PERSIST)
    private List<LogWorkEntity> listLogWorh;

    public List<LogWorkEntity> getListLogWorh() {
        return listLogWorh;
    }

    public void setListLogWorh(List<LogWorkEntity> listLogWorh) {
        this.listLogWorh = listLogWorh;
    }

    public EmployeeEntity() {
    }

    public EmployeeEntity(int id, String name, String phone, String address, PositionEntity empPosition, DepartmentEntity empDepartment, List<LogWorkEntity> listLogWorh) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.empPosition = empPosition;
        this.empDepartment = empDepartment;
        this.listLogWorh = listLogWorh;
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

    public PositionEntity getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(PositionEntity empPosition) {
        this.empPosition = empPosition;
    }

    public DepartmentEntity getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(DepartmentEntity empDepartment) {
        this.empDepartment = empDepartment;
    }

}
