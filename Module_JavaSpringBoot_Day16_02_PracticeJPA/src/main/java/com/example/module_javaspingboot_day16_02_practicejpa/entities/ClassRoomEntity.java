package com.example.module_javaspingboot_day16_02_practicejpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classroom")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClassRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "classRoomEntity")
    @JsonIgnoreProperties("classRoomEntity")
    private List<StudentEntity> studentEntityList;
}