package com.example.module_javaspringboot_day11.entities;

import com.example.module_javaspringboot_day11.dto.DetailImagesDTO;
import com.example.module_javaspringboot_day11.modal.DetailImagesModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detail_images")
public class DetailImagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductEntity productEntity;

    public static DetailImagesModal toModal(DetailImagesEntity old){
        return DetailImagesModal.builder()
                .id(old.id)
                .image(old.image).build();
    }
    public static DetailImagesDTO toDTO(DetailImagesEntity old){
        return DetailImagesDTO.builder()
                .id(old.id)
                .image(old.image).build();
    }
}
