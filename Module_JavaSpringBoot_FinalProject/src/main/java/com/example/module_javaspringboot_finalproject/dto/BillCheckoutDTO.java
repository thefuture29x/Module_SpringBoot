package com.example.module_javaspringboot_finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillCheckoutDTO {
    private String email;
    private AtomicInteger total;
    private String date;
    private String status;

}
