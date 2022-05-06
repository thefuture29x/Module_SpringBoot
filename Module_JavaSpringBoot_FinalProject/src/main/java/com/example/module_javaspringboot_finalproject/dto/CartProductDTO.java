package com.example.module_javaspringboot_finalproject.dto;

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
public class CartProductDTO {
    private Long id;
    private String name;
    private String description;
    private int oldPrice;
    private int newPrice;
    private int amountCart;
    private String image;

    private CategoryDTO categoryDTO;


//    public static ProductEntity toEntity(CartProductDTO dto){
//        return ProductEntity.builder()
//                .id(dto.id)
//                .name(dto.name)
//                .description(dto.description)
//                .oldPrice(dto.oldPrice)
//                .newPrice(dto.newPrice)
//                .image(dto.image)
//                .build();
//    }
}
