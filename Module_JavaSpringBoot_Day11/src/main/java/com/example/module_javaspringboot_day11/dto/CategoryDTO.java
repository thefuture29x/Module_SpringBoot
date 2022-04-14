package com.example.module_javaspringboot_day11.dto;

import com.example.module_javaspringboot_day11.entities.CategoryEntity;
import com.example.module_javaspringboot_day11.modal.CategoryModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;

    private List<ProductDTO> productDTOList;

    private List<DetailCategoryDTO> detailCategoryDTOList;

    public static CategoryEntity toEntity(CategoryDTO old){
        return CategoryEntity.builder()
                .id(old.id)
                .name(old.name).build();
    }
    public static CategoryModal toModal(CategoryDTO old){
        return CategoryModal.builder()
                .id(old.id)
                .name(old.name).build();
    }
}
