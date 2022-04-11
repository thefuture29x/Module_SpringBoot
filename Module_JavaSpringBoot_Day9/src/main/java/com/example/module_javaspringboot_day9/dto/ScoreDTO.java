package com.example.module_javaspringboot_day9.dto;

import com.example.module_javaspringboot_day9.entities.StudentEntity;
import com.example.module_javaspringboot_day9.entities.SubjectEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class ScoreDTO {
    private Long id;
    private int processScore;
    private int testScore;
    private int finalScore;
    private Long id_student;
    private Long id_subject;

    public ScoreDTO() {
    }

    public ScoreDTO(Long id, int processScore, int testScore, int finalScore, Long id_student, Long id_subject) {
        this.id = id;
        this.processScore = processScore;
        this.testScore = testScore;
        this.finalScore = finalScore;
        this.id_student = id_student;
        this.id_subject = id_subject;
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

    public Long getId_student() {
        return id_student;
    }

    public void setId_student(Long id_student) {
        this.id_student = id_student;
    }

    public Long getId_subject() {
        return id_subject;
    }

    public void setId_subject(Long id_subject) {
        this.id_subject = id_subject;
    }
}
