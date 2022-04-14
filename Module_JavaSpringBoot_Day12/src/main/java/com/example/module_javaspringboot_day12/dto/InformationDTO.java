package com.example.module_javaspringboot_day12.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InformationDTO {

    private Long id;
    private String name_school;
    private String name_class;
    private String name_teacher;

}
