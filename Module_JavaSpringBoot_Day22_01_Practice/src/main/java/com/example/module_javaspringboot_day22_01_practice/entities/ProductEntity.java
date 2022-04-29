package com.example.module_javaspringboot_day22_01_practice.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

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
    private int price;
    private int amount;
    private String description;
    private String image;



    @JsonIgnoreProperties("productEntityList")
    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity categoryEntity;


}