package com.example.module_javaspringboot_day9_02.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "time_table")
public class TimeTableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_time_table")
    private StudentEntity studentTimeTable;

    @ManyToOne
    @JoinColumn(name = "subject_time_table")
    private SubjectEntity subjectEntity;

    @ManyToOne
    @JoinColumn(name = "regist_time_table")
    private RegistSubjectEntity registSubjectEntity;


    public TimeTableEntity() {
    }

    public TimeTableEntity(Long id, String status, StudentEntity studentTimeTable, SubjectEntity subjectEntity, RegistSubjectEntity registSubjectEntity) {
        this.id = id;
        this.status = status;
        this.studentTimeTable = studentTimeTable;
        this.subjectEntity = subjectEntity;
        this.registSubjectEntity = registSubjectEntity;
    }

    public RegistSubjectEntity getRegistSubjectEntity() {
        return registSubjectEntity;
    }

    public void setRegistSubjectEntity(RegistSubjectEntity registSubjectEntity) {
        this.registSubjectEntity = registSubjectEntity;
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

    public StudentEntity getStudentTimeTable() {
        return studentTimeTable;
    }

    public void setStudentTimeTable(StudentEntity studentTimeTable) {
        this.studentTimeTable = studentTimeTable;
    }

    public SubjectEntity getSubjectEntity() {
        return subjectEntity;
    }

    public void setSubjectEntity(SubjectEntity subjectEntity) {
        this.subjectEntity = subjectEntity;
    }
}
