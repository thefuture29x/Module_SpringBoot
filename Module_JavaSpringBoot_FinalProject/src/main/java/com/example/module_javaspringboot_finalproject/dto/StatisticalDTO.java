package com.example.module_javaspringboot_finalproject.dto;

import com.example.module_javaspringboot_finalproject.entities.CategoryEntity;
import com.example.module_javaspringboot_finalproject.entities.ProductEntity;
import com.example.module_javaspringboot_finalproject.repository.ProductRepository;
import com.example.module_javaspringboot_finalproject.service.IProductService;
import com.example.module_javaspringboot_finalproject.service.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticalDTO {
    private String name;
    private int amountImport;
    private int amountSold;
    private int turnover;
    private int sale;
    private int soldPrice;
    private int soldImprot;
    private int turnoverReal;
    private int total;



}
