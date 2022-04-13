package com.example.module_javaspringboot_day10.entities;

import com.example.module_javaspringboot_day10.dto.ClassRoomDTO;
import com.example.module_javaspringboot_day10.modal.ClassRoomModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "class_room")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "classRoomEntityList")
    List<StudentEntity> studentEntityList = new ArrayList<>();


    public static ClassRoomModal toModal(ClassRoomEntity entity){
        return ClassRoomModal.builder()
                .id(entity.id)
                .name(entity.name).build();

    }

    public static ClassRoomDTO toDTO(ClassRoomEntity entity){
        return ClassRoomDTO.builder()
                .id(entity.id)
                .name(entity.name).build();
    }
}
