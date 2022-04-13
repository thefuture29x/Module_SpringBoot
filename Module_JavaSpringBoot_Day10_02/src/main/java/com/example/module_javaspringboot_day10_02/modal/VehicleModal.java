package com.example.module_javaspringboot_day10_02.modal;

import com.example.module_javaspringboot_day10_02.dto.CategoryVehicleDTO;
import com.example.module_javaspringboot_day10_02.dto.VehicleDTO;
import com.example.module_javaspringboot_day10_02.entities.VehicleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleModal {
    private Long id;
    private String numerical;
    private String name;
    private String number;
    private String color;
    private String image;

    private CategoryVehicleModal categoryVehicleModal;

    public static VehicleEntity toEntity(VehicleModal modal){
        return VehicleEntity.builder()
                .id(modal.id)
                .numerical(modal.numerical)
                .name(modal.name)
                .number(modal.number)
                .color(modal.color)
                .image(modal.image)
                .categoryVehicleEntity(null).build();

    }
    public static VehicleDTO toDTO(VehicleModal modal){
        return VehicleDTO.builder()
                .id(modal.id)
                .numerical(modal.numerical)
                .name(modal.name)
                .number(modal.number)
                .color(modal.color)
                .image(modal.image)
                .categoryVehicleDTO(null).build();

    }


}
