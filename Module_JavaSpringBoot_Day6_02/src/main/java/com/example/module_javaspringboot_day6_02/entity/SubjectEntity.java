package com.example.module_javaspringboot_day6_02.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subject")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "subject",cascade = CascadeType.PERSIST)
    private List<StudentEntity> listStudent;

    public SubjectEntity() {
    }

    public SubjectEntity(int id, String name, List<StudentEntity> listStudent) {
        this.id = id;
        this.name = name;
        this.listStudent = listStudent;
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

    public List<StudentEntity> getListStudent() {
        return listStudent;
    }

    public void setListStudent(List<StudentEntity> listStudent) {
        this.listStudent = listStudent;
    }

    @Override
    public String toString() {
        return "SubjectEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listStudent=" + listStudent +
                '}';
    }
}
