package com.example.module_javaspringboot_day11.modal;

import com.example.module_javaspringboot_day11.dto.DetailProductDTO;
import com.example.module_javaspringboot_day11.entities.DetailProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailProductModal {
    private Long id;

    private String size;
    private String color;
    private int amount;
    private String code;
    private String fabricMaterial;

    private Long productModalID;

    public static DetailProductEntity toEntity(DetailProductModal old){
        return DetailProductEntity.builder()
                .id(old.id)
                .size(old.size)
                .code(old.code)
                .color(old.color)
                .amount(old.amount)
                .fabricMaterial(old.fabricMaterial).build();
    }

    public static DetailProductDTO toDTO(DetailProductModal old){
        return DetailProductDTO.builder()
                .id(old.id)
                .size(old.size)
                .code(old.code)
                .color(old.color)
                .amount(old.amount)
                .fabricMaterial(old.fabricMaterial).build();
    }




}
