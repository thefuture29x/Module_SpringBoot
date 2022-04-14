package com.example.module_javaspringboot_day11.dto;

import com.example.module_javaspringboot_day11.entities.DetailImagesEntity;
import com.example.module_javaspringboot_day11.modal.DetailImagesModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailImagesDTO {
    private Long id;
    private String image;

    private ProductDTO productDTO;

    public static DetailImagesModal toModal(DetailImagesDTO old){
        return DetailImagesModal.builder()
                .id(old.id)
                .image(old.image).build();
    }
    public static DetailImagesEntity toEntity(DetailImagesDTO old){
        return DetailImagesEntity.builder()
                .id(old.id)
                .image(old.image).build();
    }
}
