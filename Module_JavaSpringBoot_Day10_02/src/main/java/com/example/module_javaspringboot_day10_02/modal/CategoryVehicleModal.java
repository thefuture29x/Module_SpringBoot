package com.example.module_javaspringboot_day10_02.modal;

import com.example.module_javaspringboot_day10_02.dto.CategoryVehicleDTO;
import com.example.module_javaspringboot_day10_02.dto.DetailCategoryDTO;
import com.example.module_javaspringboot_day10_02.dto.VehicleDTO;
import com.example.module_javaspringboot_day10_02.entities.CategoryVehicleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryVehicleModal {
    private Long id;
    private String name;
    private int price;

    private List<DetailCategoryModal> detailCategoryModalList;
    private List<VehicleModal> vehicleModalList;

    public static CategoryVehicleDTO toDTO(CategoryVehicleModal modal){
        return CategoryVehicleDTO.builder()
                .id(modal.id)
                .name(modal.name)
                .price(modal.price).build();
    }
    public static CategoryVehicleEntity toEntity(CategoryVehicleModal modal){
        return CategoryVehicleEntity.builder()
                .id(modal.id)
                .name(modal.name)
                .price(modal.price).build();
    }

}
