package com.example.module_javaspringboot_day9_02.dto;

import java.util.List;

public class RegistSubjectDTO {
    private Long id;
    private String name;
    private String time;
    private int limitQuantity;
    private List<TimeTableDTO> timeTableDTOS;

    public RegistSubjectDTO() {
    }

    public RegistSubjectDTO(Long id, String name, String time, int limitQuantity, List<TimeTableDTO> timeTableDTOS) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.limitQuantity = limitQuantity;
        this.timeTableDTOS = timeTableDTOS;
    }

    public List<TimeTableDTO> getTimeTableDTOS() {
        return timeTableDTOS;
    }

    public void setTimeTableDTOS(List<TimeTableDTO> timeTableDTOS) {
        this.timeTableDTOS = timeTableDTOS;
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
