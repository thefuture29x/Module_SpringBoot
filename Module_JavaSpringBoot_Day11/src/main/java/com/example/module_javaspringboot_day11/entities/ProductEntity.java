package com.example.module_javaspringboot_day11.entities;


import com.example.module_javaspringboot_day11.dto.ProductDTO;
import com.example.module_javaspringboot_day11.modal.ProductModal;
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
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "old_price")
    private int oldPrice;
    @Column(name = "new_price")
    private int newPrice;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity categoryEntity;

    @ManyToOne
    @JoinColumn(name = "id_detail_category")
    private DetailCategoryEntity detailCategoryEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    private DetailProductEntity detailProductEntity;

    @OneToMany(mappedBy = "productEntity",cascade = CascadeType.ALL)
    private List<DetailImagesEntity> detailImagesEntityList;


    public static ProductModal toModal(ProductEntity old){
        return ProductModal.builder()
                .id(old.id)
                .name(old.name)
                .oldPrice(old.oldPrice)
                .newPrice(old.newPrice).build();

    }
    public static ProductDTO toDTO(ProductEntity old){
        return ProductDTO.builder()
                .id(old.id)
                .name(old.name)
                .oldPrice(old.oldPrice)
                .newPrice(old.newPrice).build();

    }

}
