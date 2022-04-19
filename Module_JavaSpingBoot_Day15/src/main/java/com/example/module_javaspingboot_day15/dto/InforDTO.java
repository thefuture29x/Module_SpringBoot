package com.example.module_javaspingboot_day15.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InforDTO {
    private Long id;
    private String name;
    private Long id_classroom;
    private String name_classroom;
}
