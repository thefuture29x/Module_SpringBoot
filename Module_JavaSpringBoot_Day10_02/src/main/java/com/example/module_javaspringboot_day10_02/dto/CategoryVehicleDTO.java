package com.example.module_javaspringboot_day10_02.dto;

import com.example.module_javaspringboot_day10_02.entities.CategoryVehicleEntity;
import com.example.module_javaspringboot_day10_02.entities.DetailCategoryEntity;
import com.example.module_javaspringboot_day10_02.entities.VehicleEntity;
import com.example.module_javaspringboot_day10_02.modal.CategoryVehicleModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryVehicleDTO {
    private Long id;
    private String name;
    private int price;

    private List<DetailCategoryDTO> detailCategoryDTOList;
    private List<VehicleDTO> vehicleDTOList;

    public static CategoryVehicleEntity toEntity(CategoryVehicleDTO dto){
        return CategoryVehicleEntity.builder()
                .id(dto.id)
                .name(dto.name)
                .price(dto.price).build();
    }

    public static CategoryVehicleModal toModal(CategoryVehicleDTO dto){
        return CategoryVehicleModal.builder()
                .id(dto.id)
                .name(dto.name)
                .price(dto.price).build();
    }


}
