package com.example.module_javaspingboot_day16_02_practicejpa.dto;

import com.example.module_javaspingboot_day16_02_practicejpa.entities.ClassRoomEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private ClassRoomDTO classRoomDTO;
}
