package com.example.module_javaspringboot_day9.dto;

import com.example.module_javaspringboot_day9.entities.ScoreEntity;
import com.example.module_javaspringboot_day9.entities.StudentEntity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class SubjectDTO {
    private Long id;
    private String name;
    private String time;
    private Long id_score;

    private ScoreDTO scoreDTO;

    public ScoreDTO getScoreDTO() {
        return scoreDTO;
    }

    public void setScoreDTO(ScoreDTO scoreDTO) {
        this.scoreDTO = scoreDTO;
    }

    public SubjectDTO() {
    }

    public SubjectDTO(Long id, String name, String time, Long id_score) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.id_score = id_score;
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

    public Long getId_score() {
        return id_score;
    }

    public void setId_score(Long id_score) {
        this.id_score = id_score;
    }
}
