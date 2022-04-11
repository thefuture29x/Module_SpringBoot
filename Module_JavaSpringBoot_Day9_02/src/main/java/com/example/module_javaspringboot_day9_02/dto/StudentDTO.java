package com.example.module_javaspringboot_day9_02.dto;

import com.example.module_javaspringboot_day9_02.entities.ScoreEntity;
import com.example.module_javaspringboot_day9_02.entities.SubjectEntity;
import com.example.module_javaspringboot_day9_02.entities.TimeTableEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentDTO {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;

    private List<ScoreDTO> scoreDTOS;

    private Set<SubjectDTO> subjectDTOS = new HashSet<>();

    private List<TimeTableDTO> timeTableDTOS;



    public List<ScoreDTO> getScoreDTOS() {
        return scoreDTOS;
    }

    public void setScoreDTOS(List<ScoreDTO> scoreDTOS) {
        this.scoreDTOS = scoreDTOS;
    }

    public Set<SubjectDTO> getSubjectDTOS() {
        return subjectDTOS;
    }

    public void setSubjectDTOS(Set<SubjectDTO> subjectDTOS) {
        this.subjectDTOS = subjectDTOS;
    }

    public List<TimeTableDTO> getTimeTableDTOS() {
        return timeTableDTOS;
    }

    public void setTimeTableDTOS(List<TimeTableDTO> timeTableDTOS) {
        this.timeTableDTOS = timeTableDTOS;
    }

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
