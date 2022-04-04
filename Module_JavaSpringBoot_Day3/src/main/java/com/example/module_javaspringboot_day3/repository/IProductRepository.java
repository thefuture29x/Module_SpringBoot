package com.example.module_javaspringboot_day3.repository;

import com.example.module_javaspringboot_day3.dto.ProductDTO;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.List;

public interface IProductRepository {
    ArrayList<ProductDTO> save(ProductDTO productDTO);
    ArrayList<ProductDTO> delete(Integer id);
    ArrayList<ProductDTO> findAll();
    ProductDTO findById(Integer id);


}
