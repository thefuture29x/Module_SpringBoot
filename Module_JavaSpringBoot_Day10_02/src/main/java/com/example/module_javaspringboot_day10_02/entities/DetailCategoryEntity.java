package com.example.module_javaspringboot_day10_02.entities;

import com.example.module_javaspringboot_day10_02.dto.DetailCategoryDTO;
import com.example.module_javaspringboot_day10_02.modal.DetailCategoryModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "detail_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryVehicleEntity categoryVehicleEntity;

    public static DetailCategoryModal toModal(DetailCategoryEntity entity){
        return DetailCategoryModal.builder()
                .id(entity.id)
                .name(entity.name).build();
    }
    public static DetailCategoryDTO toDTO(DetailCategoryEntity entity){
        return DetailCategoryDTO.builder()
                .id(entity.id)
                .name(entity.name).build();
    }
}
