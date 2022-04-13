package com.example.module_javaspringboot_day10.modal;

import com.example.module_javaspringboot_day10.dto.StudentDTO;
import com.example.module_javaspringboot_day10.entities.ClassRoomEntity;
import com.example.module_javaspringboot_day10.entities.StudentEntity;
import lombok.*;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentModal {
    private Long id;
    private String name;
    private String address;

    List<ClassRoomModal> classRoomModalList = new ArrayList<>();

    public static StudentDTO toDTO(StudentModal modal){
        return StudentDTO.builder()
                .id(modal.id)
                .name(modal.name)
                .address(modal.address).build();
    }

    public static StudentEntity toEntity(StudentModal modal){
        return StudentEntity.builder()
                .id(modal.id)
                .name(modal.name)
                .address(modal.address).build();
    }

}
