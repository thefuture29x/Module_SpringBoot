package com.example.module_javaspringboot_day9.entities;

import javax.persistence.*;
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
    private List<StudentEntity> studentEntityList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_score",referencedColumnName = "id")
    private ScoreEntity scoreEntity;

    public SubjectEntity() {
    }

    public SubjectEntity(Long id, String name, String time, List<StudentEntity> studentEntityList, ScoreEntity scoreEntity) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.studentEntityList = studentEntityList;
        this.scoreEntity = scoreEntity;
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
}
