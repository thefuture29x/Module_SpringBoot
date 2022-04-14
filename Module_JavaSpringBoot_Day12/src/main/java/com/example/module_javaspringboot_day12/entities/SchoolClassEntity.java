package com.example.module_javaspringboot_day12.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "class")
public class SchoolClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_school",insertable = false,updatable = false)
    private SchoolEntity schoolEntity;

    @ManyToOne
    @JoinColumn(name = "id_teacher",insertable = false,updatable = false)
    private TeacherEntity teacherEntity;




}
