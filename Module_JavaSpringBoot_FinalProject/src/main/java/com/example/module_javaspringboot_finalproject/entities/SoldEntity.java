package com.example.module_javaspringboot_finalproject.entities;

import com.example.module_javaspringboot_finalproject.dto.SoldDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sold")
public class SoldEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int amount;
    private int total;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductEntity producSoldtEntity;

    public static SoldDTO toDTO(SoldEntity entity){
        return SoldDTO.builder()
                .id(entity.id)
                .amount(entity.amount)
                .total(entity.total)
                .date(entity.date)
                .build();
    }


}
