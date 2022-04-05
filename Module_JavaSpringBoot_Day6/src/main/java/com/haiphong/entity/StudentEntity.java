package com.haiphong.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

public class StudentEntity {
    private int id;
    private String name;
    private int address;

    public StudentEntity() {
    }

    public StudentEntity(int id, String name, int address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}
