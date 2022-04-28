package com.example.module_javaspringboot_day22_01_practice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillCheckoutDTO {
    private String email;
    private int total;
    private String date;
    private String status;

}
