package com.example.module_javaspringboot_finalproject.entities;

import com.example.module_javaspringboot_finalproject.dto.RatingDTO;
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
@Table(name = "rating")
public class RatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int point;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductEntity productEntityRating;

    public static RatingDTO toDTO(RatingEntity entity){
        return RatingDTO.builder()
                .id(entity.id)
                .point(entity.point)
                .build();
    }
}
