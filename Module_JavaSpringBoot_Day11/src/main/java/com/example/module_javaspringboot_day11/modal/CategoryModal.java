package com.example.module_javaspringboot_day11.modal;

import com.example.module_javaspringboot_day11.dto.CategoryDTO;
import com.example.module_javaspringboot_day11.entities.CategoryEntity;
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
public class CategoryModal {
    private Long id;
    private String name;

    private List<Long> productModalListID;

    private List<Long> detailCategoryModalListID;

    public static CategoryEntity toEntity(CategoryModal old){
        return CategoryEntity.builder()
                .id(old.id)
                .name(old.name).build();
    }
    public static CategoryDTO toDTO(CategoryModal old){
        return CategoryDTO.builder()
                .id(old.id)
                .name(old.name).build();
    }

}
