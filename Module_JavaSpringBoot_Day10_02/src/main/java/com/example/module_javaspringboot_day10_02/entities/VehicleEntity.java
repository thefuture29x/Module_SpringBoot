package com.example.module_javaspringboot_day10_02.entities;

import com.example.module_javaspringboot_day10_02.dto.VehicleDTO;
import com.example.module_javaspringboot_day10_02.modal.VehicleModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numerical;
    private String name;
    private String number;
    private String color;
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryVehicleEntity categoryVehicleEntity;

    public static VehicleDTO toDTO(VehicleEntity entity){
        return VehicleDTO.builder()
                .id(entity.id)
                .numerical(entity.numerical)
                .name(entity.name)
                .number(entity.number)
                .color(entity.color)
                .image(entity.image)
                .categoryVehicleDTO(null).build();

    }
    public static VehicleModal toModal(VehicleEntity entity){
        return VehicleModal.builder()
                .id(entity.id)
                .numerical(entity.numerical)
                .name(entity.name)
                .number(entity.number)
                .color(entity.color)
                .image(entity.image)
                .categoryVehicleModal(null).build();

    }



}
