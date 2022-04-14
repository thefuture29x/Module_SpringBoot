package com.example.module_javaspringboot_day11.dto;

import com.example.module_javaspringboot_day11.entities.ProductEntity;
import com.example.module_javaspringboot_day11.modal.ProductModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private int oldPrice;
    private int newPrice;

    private CategoryDTO categoryDTO;

    private DetailCategoryDTO detailCategoryDTO;

    private DetailProductDTO detailProductDTO;

    private List<DetailImagesDTO> detailImagesDTOList;

    public static ProductModal toModal(ProductDTO old){
        return ProductModal.builder()
                .id(old.id)
                .name(old.name)
                .oldPrice(old.oldPrice)
                .newPrice(old.newPrice).build();

    }
    public static ProductEntity toEntity(ProductDTO old){
        return ProductEntity.builder()
                .id(old.id)
                .name(old.name)
                .oldPrice(old.oldPrice)
                .newPrice(old.newPrice).build();

    }


}
