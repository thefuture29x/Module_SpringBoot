package com.example.module_javaspringboot_finalproject.entities;

import com.example.module_javaspringboot_finalproject.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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
    private String description;
    @Column(name = "old_price")
    private int oldPrice;
    @Column(name = "new_price")
    private int newPrice;
    @Column(name = "import_price")
    private int importPrice;
    private int amount;
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "productEntityComments",cascade = CascadeType.ALL)
    private List<CommentsEntity> commentsEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "productEntityRating", cascade = CascadeType.ALL)
    private List<RatingEntity> ratingEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "producSoldtEntity",cascade = CascadeType.ALL)
    private List<SoldEntity> soldEntityList = new ArrayList<>();

    public static ProductDTO toDTO(ProductEntity entity){
        return ProductDTO.builder()
                .id(entity.id)
                .name(entity.name)
                .description(entity.description)
                .oldPrice(entity.oldPrice)
                .newPrice(entity.newPrice)
                .importPrice(entity.importPrice)
                .amount(entity.amount)
                .image(entity.image)
                .build();
    }
}
