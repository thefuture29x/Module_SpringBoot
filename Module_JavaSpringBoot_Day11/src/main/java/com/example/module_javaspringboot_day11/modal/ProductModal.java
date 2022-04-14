package com.example.module_javaspringboot_day11.modal;

import com.example.module_javaspringboot_day11.dto.ProductDTO;
import com.example.module_javaspringboot_day11.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductModal {
    private Long id;
    private String name;
    private int oldPrice;
    private int newPrice;

    private Long categoryModalID;

    private Long detailCategoryModalID;

    private Long detailProductModalID;

    private List<Long> detailImagesModalListID;


    public static ProductDTO toDTO(ProductModal old){
        return ProductDTO.builder()
                .id(old.id)
                .name(old.name)
                .oldPrice(old.oldPrice)
                .newPrice(old.newPrice).build();

    }
    public static ProductEntity toEntity(ProductModal old){
        return ProductEntity.builder()
                .id(old.id)
                .name(old.name)
                .oldPrice(old.oldPrice)
                .newPrice(old.newPrice).build();

    }


}
