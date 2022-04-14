package com.example.module_javaspringboot_day12.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InformationModal {

    private Long id;
    private String name_school;
    private String name_class;
    private String name_teacher;

}
