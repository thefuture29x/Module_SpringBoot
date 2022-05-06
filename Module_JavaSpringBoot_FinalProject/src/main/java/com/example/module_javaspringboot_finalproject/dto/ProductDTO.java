package com.example.module_javaspringboot_finalproject.dto;

import com.example.module_javaspringboot_finalproject.entities.CategoryEntity;
import com.example.module_javaspringboot_finalproject.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private int oldPrice;
    private int newPrice;
    private int importPrice;
    private int amount;
    private String image;

    private CategoryDTO categoryDTO;

    private List<CommentsDTO> commentsDTOList = new ArrayList<>();

    private List<RatingDTO> ratingDTOList = new ArrayList<>();

    public static ProductEntity toEntity(ProductDTO dto){
        return ProductEntity.builder()
                .id(dto.id)
                .name(dto.name)
                .description(dto.description)
                .oldPrice(dto.oldPrice)
                .newPrice(dto.newPrice)
                .importPrice(dto.importPrice)
                .amount(dto.amount)
                .image(dto.image)
                .build();
    }
}
