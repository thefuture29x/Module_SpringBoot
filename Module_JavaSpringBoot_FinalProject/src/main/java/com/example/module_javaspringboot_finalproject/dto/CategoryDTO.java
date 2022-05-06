package com.example.module_javaspringboot_finalproject.dto;

import com.example.module_javaspringboot_finalproject.entities.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;

    private List<ProductDTO> productDTOList;

    public static CategoryEntity toEntity(CategoryDTO dto){
        return CategoryEntity.builder()
                .id(dto.id)
                .name(dto.name)
                .build();
    }

}
