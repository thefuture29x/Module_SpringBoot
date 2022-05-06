package com.example.module_javaspringboot_finalproject.dto;

import com.example.module_javaspringboot_finalproject.entities.CategoryEntity;
import com.example.module_javaspringboot_finalproject.entities.RatingEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingDTO {
    private Long id;
    private int point;

    private ProductDTO productDTORating;

    public static RatingEntity toEntity(RatingDTO dto){
        return RatingEntity.builder()
                .id(dto.id)
                .point(dto.point)
                .build();
    }

}
