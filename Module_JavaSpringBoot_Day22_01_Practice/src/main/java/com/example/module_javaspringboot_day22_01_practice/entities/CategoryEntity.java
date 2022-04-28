package com.example.module_javaspringboot_day22_01_practice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnoreProperties("categoryEntity")
    @OneToMany(mappedBy = "categoryEntity",cascade = CascadeType.ALL)
    private List<ProductEntity> productEntityList;


}
