package com.example.module_javaspringboot_day5_02.repository;


import com.example.module_javaspringboot_day5_02.dto.ProductDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IProductRepository extends CrudRepository<ProductDTO, Integer> {
    @Query(value = "select * from product where name = :name")
    ProductDTO findByName(@Param("name") String search);

}
