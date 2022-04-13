package com.example.module_javaspringboot_day10_02.dto;

import com.example.module_javaspringboot_day10_02.entities.VehicleEntity;
import com.example.module_javaspringboot_day10_02.modal.VehicleModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDTO {
    private Long id;
    private String numerical;
    private String name;
    private String number;
    private String color;
    private String image;

    private CategoryVehicleDTO categoryVehicleDTO;

    public static VehicleEntity toEntity(VehicleDTO dto){
        return VehicleEntity.builder()
                .id(dto.id)
                .numerical(dto.numerical)
                .name(dto.name)
                .number(dto.number)
                .color(dto.color)
                .image(dto.image)
                .categoryVehicleEntity(null).build();

    }
    public static VehicleModal toModal(VehicleDTO dto){
        return VehicleModal.builder()
                .id(dto.id)
                .numerical(dto.numerical)
                .name(dto.name)
                .number(dto.number)
                .color(dto.color)
                .image(dto.image)
                .categoryVehicleModal(null).build();

    }


}
