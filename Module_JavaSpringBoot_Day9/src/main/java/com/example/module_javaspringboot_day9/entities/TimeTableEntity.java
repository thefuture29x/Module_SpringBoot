package com.example.module_javaspringboot_day9.entities;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.persistence.*;

@Entity
@Table(name = "time_table")
public class TimeTableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String time;
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_time_table")
    private StudentEntity studentTimeTable;

    public TimeTableEntity() {
    }

    public TimeTableEntity(Long id, String name, String time, String status, StudentEntity studentTimeTable) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.status = status;
        this.studentTimeTable = studentTimeTable;
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

    public StudentEntity getStudentTimeTable() {
        return studentTimeTable;
    }

    public void setStudentTimeTable(StudentEntity studentTimeTable) {
        this.studentTimeTable = studentTimeTable;
    }
}
