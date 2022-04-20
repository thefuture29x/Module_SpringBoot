package com.example.module_javaspingboot_day15.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("teacher")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity {
    @Id
    private Long id;
    private String name;
    private Long id_classroom;

}
