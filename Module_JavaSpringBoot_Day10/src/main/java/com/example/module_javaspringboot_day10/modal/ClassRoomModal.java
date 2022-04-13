package com.example.module_javaspringboot_day10.modal;

import com.example.module_javaspringboot_day10.dto.ClassRoomDTO;
import com.example.module_javaspringboot_day10.entities.ClassRoomEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoomModal {
    private Long id;
    private String name;
    
    private List<StudentModal> studentModalList;

    public static ClassRoomDTO toDTO(ClassRoomModal modal){
        return ClassRoomDTO.builder()
                .id(modal.id)
                .name(modal.name).build();
    }

    public static ClassRoomEntity toEntity(ClassRoomModal modal){
        return ClassRoomEntity.builder()
                .id(modal.id)
                .name(modal.name).build();
    }
}
