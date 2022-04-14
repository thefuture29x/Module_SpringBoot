package com.example.module_javaspringboot_day11.entities;

import com.example.module_javaspringboot_day11.dto.DetailCategoryDTO;
import com.example.module_javaspringboot_day11.modal.DetailCategoryModal;
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
@Table(name = "detail_category")
public class DetailCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "detailCategoryEntity",cascade = CascadeType.ALL)
    private List<ProductEntity> productEntityList;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity category;

    public static DetailCategoryDTO toDTO(DetailCategoryEntity old){
        return DetailCategoryDTO.builder()
                .id(old.id)
                .name(old.name).build();
    }
    public static DetailCategoryModal toModal(DetailCategoryEntity old){
        return DetailCategoryModal.builder()
                .id(old.id)
                .name(old.name).build();
    }

}
