package com.example.module_javaspringboot_day11.modal;

import com.example.module_javaspringboot_day11.dto.DetailImagesDTO;
import com.example.module_javaspringboot_day11.entities.DetailImagesEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailImagesModal {
    private Long id;
    private String image;

    private Long productModalID;

    public static DetailImagesEntity toEntity(DetailImagesModal old){
        return DetailImagesEntity.builder()
                .id(old.id)
                .image(old.image).build();
    }
    public static DetailImagesDTO toDTO(DetailImagesModal old){
        return DetailImagesDTO.builder()
                .id(old.id)
                .image(old.image).build();
    }
}
