package com.example.module_javaspringboot_day10_02.dto;

import com.example.module_javaspringboot_day10_02.entities.CategoryVehicleEntity;
import com.example.module_javaspringboot_day10_02.entities.DetailCategoryEntity;
import com.example.module_javaspringboot_day10_02.modal.CategoryVehicleModal;
import com.example.module_javaspringboot_day10_02.modal.DetailCategoryModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailCategoryDTO {
    private Long id;
    private String name;

    private CategoryVehicleDTO categoryVehicleDTO;

    public static DetailCategoryModal toModal(DetailCategoryDTO dto){
        return DetailCategoryModal.builder()
                .id(dto.id)
                .name(dto.name).build();
    }
    public static DetailCategoryEntity toEntity(DetailCategoryDTO dto){
        return DetailCategoryEntity.builder()
                .id(dto.id)
                .name(dto.name).build();
    }
}
