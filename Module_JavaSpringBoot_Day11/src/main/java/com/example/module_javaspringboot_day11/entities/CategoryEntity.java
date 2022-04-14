package com.example.module_javaspringboot_day11.entities;

import com.example.module_javaspringboot_day11.dto.CategoryDTO;
import com.example.module_javaspringboot_day11.modal.CategoryModal;
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

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<DetailCategoryEntity> detailCategoryEntityList;


    public static CategoryDTO toDTO(CategoryEntity old){
        return CategoryDTO.builder()
                .id(old.id)
                .name(old.name).build();
    }
    public static CategoryModal toModal(CategoryEntity old){
        return CategoryModal.builder()
                .id(old.id)
                .name(old.name).build();
    }
}
