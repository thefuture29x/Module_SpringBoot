package com.example.module_javaspringboot_day9.dto;

import javax.persistence.Column;

public class RegistSubjectDTO {
    private Long id;
    private String name;
    private String time;
    private int limitQuantity;

    public RegistSubjectDTO() {
    }

    public RegistSubjectDTO(Long id, String name, String time, int limitQuantity) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.limitQuantity = limitQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLimitQuantity() {
        return limitQuantity;
    }

    public void setLimitQuantity(int limitQuantity) {
        this.limitQuantity = limitQuantity;
    }
}
