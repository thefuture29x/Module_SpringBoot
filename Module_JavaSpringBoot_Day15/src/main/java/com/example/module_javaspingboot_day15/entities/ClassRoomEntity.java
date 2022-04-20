package com.example.module_javaspingboot_day15.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;


@Table("classroom")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoomEntity {
    @Id
    private Long id;
    private String name;

    private List<TeacherEntity> teacherEntityList;

}
