package com.example.module_javaspringboot_day10_02.entities;

import com.example.module_javaspringboot_day10_02.dto.CategoryVehicleDTO;
import com.example.module_javaspringboot_day10_02.modal.CategoryVehicleModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category_vehicle")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryVehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;

    @OneToMany(mappedBy = "categoryVehicleEntity")
    private List<DetailCategoryEntity> detailCategoryEntityList;
    @OneToMany(mappedBy = "categoryVehicleEntity")
    private List<VehicleEntity> vehicleEntityList;


    public static CategoryVehicleDTO toDTO(CategoryVehicleEntity entity){
        return CategoryVehicleDTO.builder()
                .id(entity.id)
                .name(entity.name)
                .price(entity.price).build();
    }

    public static CategoryVehicleModal toModal(CategoryVehicleEntity entity){
        return CategoryVehicleModal.builder()
                .id(entity.id)
                .name(entity.name)
                .price(entity.price).build();
    }
}
