package com.example.module_javaspringboot_day14_02.entities;

import com.example.module_javaspringboot_day14_02.dto.ProductDTO;
import com.example.module_javaspringboot_day14_02.modal.ProductModal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private int remaining;
    private int sold;
    @Column(name = "id_user")
    private Long idUser;
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity categoryEntity;


    public static ProductModal toModal(ProductEntity old){
        return ProductModal.builder()
                .id(old.id)
                .name(old.name)
                .price(old.price)
                .remaining(old.remaining)
                .sold(old.sold)
                .image(old.image)
                .idUser(old.idUser).build();

    }
    public static ProductDTO toDTO(ProductEntity old){
        return ProductDTO.builder()
                .id(old.id)
                .name(old.name)
                .price(old.price)
                .remaining(old.remaining)
                .sold(old.sold)
                .image(old.image)
                .idUser(old.idUser).build();

    }
}
