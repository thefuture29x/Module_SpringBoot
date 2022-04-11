package com.example.module_javaspringboot_day9_02.dto;

import com.example.module_javaspringboot_day9_02.entities.ScoreEntity;
import com.example.module_javaspringboot_day9_02.entities.StudentEntity;
import com.example.module_javaspringboot_day9_02.entities.SubjectEntity;
import com.example.module_javaspringboot_day9_02.entities.TimeTableEntity;

import javax.persistence.*;
import java.util.List;

public class SubjectDTO {
    private Long id;
    private String name;
    private String time;
    private ScoreDTO scoreDTO;
    private List<StudentDTO> studentDTOs;
    private List<TimeTableDTO> timeTableDTOs;

    public SubjectDTO() {
    }

    public SubjectDTO(Long id, String name, String time, ScoreDTO scoreDTO, List<StudentDTO> studentDTOs, List<TimeTableDTO> timeTableDTOs) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.scoreDTO = scoreDTO;
        this.studentDTOs = studentDTOs;
        this.timeTableDTOs = timeTableDTOs;
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

    public ScoreDTO getScoreDTO() {
        return scoreDTO;
    }

    public void setScoreDTO(ScoreDTO scoreDTO) {
        this.scoreDTO = scoreDTO;
    }

    public List<StudentDTO> getStudentDTOs() {
        return studentDTOs;
    }

    public void setStudentDTOs(List<StudentDTO> studentDTOs) {
        this.studentDTOs = studentDTOs;
    }

    public List<TimeTableDTO> getTimeTableDTOs() {
        return timeTableDTOs;
    }

    public void setTimeTableDTOs(List<TimeTableDTO> timeTableDTOs) {
        this.timeTableDTOs = timeTableDTOs;
    }
}
