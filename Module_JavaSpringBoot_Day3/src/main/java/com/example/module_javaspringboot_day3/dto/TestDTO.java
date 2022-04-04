package com.example.module_javaspringboot_day3.dto;

import javax.persistence.*;

@Entity
@Table(name = "TestDTO")
public class TestDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Override
    public String toString() {
        return "TestDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public TestDTO() {
    }

    public TestDTO(int id, String name) {
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
