package com.example.module_javaspringboot_day10.dto;

import com.example.module_javaspringboot_day10.entities.ClassRoomEntity;
import com.example.module_javaspringboot_day10.entities.StudentEntity;
import com.example.module_javaspringboot_day10.modal.StudentModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private String address;

    List<ClassRoomDTO> classRoomDTOList = new ArrayList<>();

    public static StudentEntity toEntity(StudentDTO dto){
        return StudentEntity.builder()
                .id(dto.id)
                .name(dto.name)
                .address(dto.address).build();
    }
    public static StudentModal toModal(StudentDTO dto){
        return StudentModal.builder()
                .id(dto.id)
                .name(dto.name)
                .address(dto.address).build();
    }
}
