package com.example.module_javaspringboot_day9_02.dto;

import com.example.module_javaspringboot_day9_02.entities.StudentEntity;
import com.example.module_javaspringboot_day9_02.entities.SubjectEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

public class TimeTableDTO {
    private Long id;
    private String status;
    private StudentDTO studentDTO;
    private SubjectDTO subjectDTO;
    private RegistSubjectDTO registSubjectDTO;


    public TimeTableDTO() {
    }

    public TimeTableDTO(Long id, String status, StudentDTO studentDTO, SubjectDTO subjectDTO, RegistSubjectDTO registSubjectDTO) {
        this.id = id;
        this.status = status;
        this.studentDTO = studentDTO;
        this.subjectDTO = subjectDTO;
        this.registSubjectDTO = registSubjectDTO;
    }

    public RegistSubjectDTO getRegistSubjectDTO() {
        return registSubjectDTO;
    }

    public void setRegistSubjectDTO(RegistSubjectDTO registSubjectDTO) {
        this.registSubjectDTO = registSubjectDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }

    public void setSubjectDTO(SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }
}
