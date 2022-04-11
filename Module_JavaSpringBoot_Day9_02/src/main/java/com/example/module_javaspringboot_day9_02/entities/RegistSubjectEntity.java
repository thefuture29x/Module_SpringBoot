package com.example.module_javaspringboot_day9_02.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "regist_subject")
public class RegistSubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String time;
    @Column(name = "limit_quantity")
    private int limitQuantity;

    @OneToMany(mappedBy = "registSubjectEntity",cascade = CascadeType.ALL)
    private List<TimeTableEntity> timeTableEntity;

    public RegistSubjectEntity() {
    }

    public RegistSubjectEntity(Long id, String name, String time, int limitQuantity, List<TimeTableEntity> timeTableEntity) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.limitQuantity = limitQuantity;
        this.timeTableEntity = timeTableEntity;
    }

    public List<TimeTableEntity> getTimeTableEntity() {
        return timeTableEntity;
    }

    public void setTimeTableEntity(List<TimeTableEntity> timeTableEntity) {
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

    public int getLimitQuantity() {
        return limitQuantity;
    }

    public void setLimitQuantity(int limitQuantity) {
        this.limitQuantity = limitQuantity;
    }
}
