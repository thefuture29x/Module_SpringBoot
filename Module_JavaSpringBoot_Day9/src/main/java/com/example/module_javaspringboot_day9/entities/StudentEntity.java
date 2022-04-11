package com.example.module_javaspringboot_day9.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "studentEntity",cascade = CascadeType.ALL)
    private List<ScoreEntity> listScore;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_subject",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_subject"))
    private List<SubjectEntity> listSubject;

    @OneToMany(mappedBy = "studentTimeTable",cascade = CascadeType.ALL)
    private List<TimeTableEntity> timeTableEntityList;

    public StudentEntity() {
    }

    public StudentEntity(Long id, String name, String address, String phoneNumber, List<ScoreEntity> listScore, List<SubjectEntity> listSubject, List<TimeTableEntity> timeTableEntityList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.listScore = listScore;
        this.listSubject = listSubject;
        this.timeTableEntityList = timeTableEntityList;
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

    public List<ScoreEntity> getListScore() {
        return listScore;
    }

    public void setListScore(List<ScoreEntity> listScore) {
        this.listScore = listScore;
    }

    public List<SubjectEntity> getListSubject() {
        return listSubject;
    }

    public void setListSubject(List<SubjectEntity> listSubject) {
        this.listSubject = listSubject;
    }

    public List<TimeTableEntity> getTimeTableEntityList() {
        return timeTableEntityList;
    }

    public void setTimeTableEntityList(List<TimeTableEntity> timeTableEntityList) {
        this.timeTableEntityList = timeTableEntityList;
    }
}
