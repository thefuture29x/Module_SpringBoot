package com.example.module_javaspringboot_day9_02.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String time;

    @ManyToMany(mappedBy = "listSubject")
    private List<StudentEntity> studentEntityList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_score",referencedColumnName = "id")
    private ScoreEntity scoreEntity;

    @OneToMany(mappedBy = "subjectEntity",cascade = CascadeType.ALL)
    private List<TimeTableEntity> timeTableEntity;

    public SubjectEntity() {
    }

    public SubjectEntity(Long id, String name, String time, List<StudentEntity> studentEntityList, ScoreEntity scoreEntity, List<TimeTableEntity> timeTableEntity) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.studentEntityList = studentEntityList;
        this.scoreEntity = scoreEntity;
        this.timeTableEntity = timeTableEntity;
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

    public List<StudentEntity> getStudentEntityList() {
        return studentEntityList;
    }

    public void setStudentEntityList(List<StudentEntity> studentEntityList) {
        this.studentEntityList = studentEntityList;
    }

    public ScoreEntity getScoreEntity() {
        return scoreEntity;
    }

    public void setScoreEntity(ScoreEntity scoreEntity) {
        this.scoreEntity = scoreEntity;
    }

    public List<TimeTableEntity> getTimeTableEntity() {
        return timeTableEntity;
    }

    public void setTimeTableEntity(List<TimeTableEntity> timeTableEntity) {
        this.timeTableEntity = timeTableEntity;
    }
}
