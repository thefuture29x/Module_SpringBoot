package com.example.module_javaspringboot_day11.entities;

import com.example.module_javaspringboot_day11.dto.DetailProductDTO;
import com.example.module_javaspringboot_day11.modal.DetailProductModal;
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
@Entity
@Table(name = "detail_product")
public class DetailProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String size;
    private String color;
    private int amount;
    private String code;
    @Column(name = "fabric_material")
    private String fabricMaterial;

    @OneToOne(mappedBy = "detailProductEntity")
    private ProductEntity productEntity;

    public static DetailProductModal toModal(DetailProductEntity old){
        return DetailProductModal.builder()
                .id(old.id)
                .size(old.size)
                .code(old.code)
                .color(old.color)
                .amount(old.amount)
                .fabricMaterial(old.fabricMaterial).build();
    }

    public static DetailProductDTO toDTO(DetailProductEntity old){
        return DetailProductDTO.builder()
                .id(old.id)
                .size(old.size)
                .code(old.code)
                .color(old.color)
                .amount(old.amount)
                .fabricMaterial(old.fabricMaterial).build();
    }


}
