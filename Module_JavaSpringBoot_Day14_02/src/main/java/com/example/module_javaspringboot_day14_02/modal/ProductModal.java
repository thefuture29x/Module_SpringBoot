package com.example.module_javaspringboot_day14_02.modal;

import com.example.module_javaspringboot_day14_02.dto.ProductDTO;
import com.example.module_javaspringboot_day14_02.entities.CategoryEntity;
import com.example.module_javaspringboot_day14_02.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductModal {

    private Long id;
    private String name;
    private int price;
    private int remaining;
    private int sold;
    private Long idUser;
    private String image;

    private Long idCategoryModal;

    public static ProductEntity toEntity(ProductModal old){
        return ProductEntity.builder()
                .id(old.id)
                .name(old.name)
                .price(old.price)
                .remaining(old.remaining)
                .sold(old.sold)
                .image(old.image)
                .idUser(old.idUser).build();

    }

    public static ProductDTO toDTO(ProductModal old){
        return ProductDTO.builder()
                .id(old.id)
                .name(old.name)
                .price(old.price)
                .remaining(old.remaining)
                .sold(old.sold)
                .image(old.image)
                .idUser(old.idUser).build();

    }

}
