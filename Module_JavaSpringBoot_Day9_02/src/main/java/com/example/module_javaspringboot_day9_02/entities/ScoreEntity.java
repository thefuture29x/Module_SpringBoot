package com.example.module_javaspringboot_day9_02.entities;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "process_score")
    private int processScore;
    @Column(name = "test_score")
    private int testScore;
    @Column(name = "final_score")
    private int finalScore;


    @ManyToOne
    @JoinColumn(name = "id_student")
    private StudentEntity studentEntity;

    @OneToOne(mappedBy = "scoreEntity")
    private SubjectEntity subjectEntity;

    public ScoreEntity() {
    }

    public ScoreEntity(Long id, int processScore, int testScore, int finalScore, StudentEntity studentEntity, SubjectEntity subjectEntity) {
        this.id = id;
        this.processScore = processScore;
        this.testScore = testScore;
        this.finalScore = finalScore;
        this.studentEntity = studentEntity;
        this.subjectEntity = subjectEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProcessScore() {
        return processScore;
    }

    public void setProcessScore(int processScore) {
        this.processScore = processScore;
    }

    public int getTestScore() {
        return testScore;
    }

    public void setTestScore(int testScore) {
        this.testScore = testScore;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public SubjectEntity getSubjectEntity() {
        return subjectEntity;
    }

    public void setSubjectEntity(SubjectEntity subjectEntity) {
        this.subjectEntity = subjectEntity;
    }
}
