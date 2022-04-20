package com.example.module_javaspingboot_day16_02_practicejpa.dto;

import com.example.module_javaspingboot_day16_02_practicejpa.entities.ClassRoomEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoomDTO {
    private Long id;
    private String name;
    private List<StudentDTO> studentDTOList;
}
