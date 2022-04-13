package com.example.module_javaspringboot_day10.dto;

import com.example.module_javaspringboot_day10.entities.ClassRoomEntity;
import com.example.module_javaspringboot_day10.modal.ClassRoomModal;
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


    public static ClassRoomEntity toEntity(ClassRoomDTO dto){
        return ClassRoomEntity.builder()
                .id(dto.id)
                .name(dto.name).build();
    }
    public static ClassRoomModal toModal(ClassRoomDTO dto){
        return ClassRoomModal.builder()
                .id(dto.id)
                .name(dto.name).build();
    }
}
