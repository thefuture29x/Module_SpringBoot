package com.example.module_javaspringboot_day10_02.modal;

import com.example.module_javaspringboot_day10_02.dto.CategoryVehicleDTO;
import com.example.module_javaspringboot_day10_02.dto.DetailCategoryDTO;
import com.example.module_javaspringboot_day10_02.entities.DetailCategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailCategoryModal {
    private Long id;
    private String name;

    private CategoryVehicleModal categoryVehicleModal;

    public static DetailCategoryDTO toDTO(DetailCategoryModal modal){
        return DetailCategoryDTO.builder()
                .id(modal.id)
                .name(modal.name).build();
    }
    public static DetailCategoryEntity toEntity(DetailCategoryModal modal){
        return DetailCategoryEntity.builder()
                .id(modal.id)
                .name(modal.name).build();
    }


}
