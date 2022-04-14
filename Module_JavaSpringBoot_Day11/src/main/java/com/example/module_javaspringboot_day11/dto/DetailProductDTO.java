package com.example.module_javaspringboot_day11.dto;

import com.example.module_javaspringboot_day11.entities.DetailProductEntity;
import com.example.module_javaspringboot_day11.modal.DetailProductModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailProductDTO {
    private Long id;

    private String size;
    private String color;
    private int amount;
    private String code;
    private String fabricMaterial;

    private ProductDTO productDTO;

    public static DetailProductModal toModal(DetailProductDTO old){
        return DetailProductModal.builder()
                .id(old.id)
                .size(old.size)
                .code(old.code)
                .color(old.color)
                .amount(old.amount)
                .fabricMaterial(old.fabricMaterial).build();
    }

    public static DetailProductEntity toEntity(DetailProductDTO old){
        return DetailProductEntity.builder()
                .id(old.id)
                .size(old.size)
                .code(old.code)
                .color(old.color)
                .amount(old.amount)
                .fabricMaterial(old.fabricMaterial).build();
    }



}
