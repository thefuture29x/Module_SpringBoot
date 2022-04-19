package com.example.module_javaspringboot_day14_02.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModal {
    private Long id;
    private String name;

    private List<Long> listIDProductModal;
}
