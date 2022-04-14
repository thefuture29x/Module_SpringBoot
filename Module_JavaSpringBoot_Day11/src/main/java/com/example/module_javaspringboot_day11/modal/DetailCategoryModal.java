package com.example.module_javaspringboot_day11.modal;

import com.example.module_javaspringboot_day11.dto.DetailCategoryDTO;
import com.example.module_javaspringboot_day11.entities.DetailCategoryEntity;
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
public class DetailCategoryModal {
    private Long id;
    private String name;

    private List<Long> productModalListID;

    private Long categoryID;

    public static DetailCategoryDTO toDTO(DetailCategoryModal old){
        return DetailCategoryDTO.builder()
                .id(old.id)
                .name(old.name).build();
    }
    public static DetailCategoryEntity toEntity(DetailCategoryModal old){
        return DetailCategoryEntity.builder()
                .id(old.id)
                .name(old.name).build();
    }

}
