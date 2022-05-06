package com.example.module_javaspringboot_finalproject.entities;

import com.example.module_javaspringboot_finalproject.dto.CategoryDTO;
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
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "categoryEntity",cascade = CascadeType.ALL)
    private List<ProductEntity> productEntityList;

    public static CategoryDTO toDTO(CategoryEntity entity){
        return CategoryDTO.builder()
                .id(entity.id)
                .name(entity.name)
                .build();
    }

}
