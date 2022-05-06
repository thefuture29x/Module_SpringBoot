package com.example.module_javaspringboot_finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountRatingDTO {
    private int point1;
    private int point2;
    private int point3;
    private int point4;
    private int point5;
    private int avgPoint;
}
