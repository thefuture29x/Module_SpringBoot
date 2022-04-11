package com.example.module_javaspringboot_day9.dto;

import com.example.module_javaspringboot_day9.entities.StudentEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

public class TimeTableDTO {
    private Long id;
    private String name;
    private String time;
    private String status;
    private Long id_timeTable;

    private List<ScoreDTO> listScore;

    public List<ScoreDTO> getListScore() {
        return listScore;
    }

    public void setListScore(List<ScoreDTO> listScore) {
        this.listScore = listScore;
    }
    public TimeTableDTO() {
    }

    public TimeTableDTO(Long id, String name, String time, String status, Long id_timeTable) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.status = status;
        this.id_timeTable = id_timeTable;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId_timeTable() {
        return id_timeTable;
    }

    public void setId_timeTable(Long id_timeTable) {
        this.id_timeTable = id_timeTable;
    }
}
