package com.example.module_javaspringboot_day14_02.dto;

import com.example.module_javaspringboot_day14_02.entities.ProductEntity;
import com.example.module_javaspringboot_day14_02.modal.ProductModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private int price;
    private int remaining;
    private int sold;
    private Long idUser;
    private String image;
    private MultipartFile file;

    private CategoryDTO categoryDTO;

    public static ProductEntity toEntity(ProductDTO old){
        return ProductEntity.builder()
                .id(old.id)
                .name(old.name)
                .price(old.price)
                .remaining(old.remaining)
                .sold(old.sold)
                .image(old.image)
                .idUser(old.idUser).build();

    }

    public static ProductModal toDTO(ProductDTO old){
        return ProductModal.builder()
                .id(old.id)
                .name(old.name)
                .price(old.price)
                .remaining(old.remaining)
                .sold(old.sold)
                .image(old.image)
                .idUser(old.idUser).build();

    }

}
