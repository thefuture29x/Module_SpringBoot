package com.haiphong.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

public class StudentEntity {
    private int id;
    private String name;
    private ClassRoomEntity address;

    public StudentEntity() {
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

    public StudentEntity(int id, String name, ClassRoomEntity address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public ClassRoomEntity getAddress() {
        return address;
    }

    public void setAddress(ClassRoomEntity address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
