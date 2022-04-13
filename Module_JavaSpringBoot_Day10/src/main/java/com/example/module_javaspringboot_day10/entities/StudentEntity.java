package com.example.module_javaspringboot_day10.entities;

import com.example.module_javaspringboot_day10.dto.StudentDTO;
import com.example.module_javaspringboot_day10.modal.StudentModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_class",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_class"))
    List<ClassRoomEntity> classRoomEntityList = new ArrayList<>();

    public static StudentModal toModal(StudentEntity entity){
        return StudentModal.builder()
                .id(entity.id)
                .name(entity.name)
                .address(entity.address).build();

    }

    public static StudentDTO toDTO(StudentEntity entity){
        return StudentDTO.builder()
                .id(entity.id)
                .name(entity.name)
                .address(entity.address).build();
    }

}
