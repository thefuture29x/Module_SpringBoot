package com.example.module_javaspringboot_day11.dto;

import com.example.module_javaspringboot_day11.entities.DetailCategoryEntity;
import com.example.module_javaspringboot_day11.modal.DetailCategoryModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailCategoryDTO {
    private Long id;
    private String name;

    private List<ProductDTO> productDTOList;

    private CategoryDTO category;

    public static DetailCategoryEntity toEntity(DetailCategoryDTO old){
        return DetailCategoryEntity.builder()
                .id(old.id)
                .name(old.name).build();
    }
    public static DetailCategoryModal toModal(DetailCategoryDTO old){
        return DetailCategoryModal.builder()
                .id(old.id)
                .name(old.name).build();
    }
}
