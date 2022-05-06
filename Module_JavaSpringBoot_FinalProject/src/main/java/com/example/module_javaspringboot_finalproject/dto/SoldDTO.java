package com.example.module_javaspringboot_finalproject.dto;

import com.example.module_javaspringboot_finalproject.entities.SoldEntity;
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
public class SoldDTO {
    private Long id;
    private int amount;
    private int total;
    private Date date;

    private ProductDTO productDTO;

    public static SoldEntity toEntity(SoldDTO dto){
        return SoldEntity.builder()
                .id(dto.id)
                .amount(dto.amount)
                .total(dto.total)
                .date(dto.date)
                .build();
    }
}
