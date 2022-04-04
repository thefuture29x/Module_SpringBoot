package com.example.module_javaspringboot_day5_02.repository;


import com.example.module_javaspringboot_day5_02.dto.CategoryDTO;
import com.example.module_javaspringboot_day5_02.dto.ProductDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface ICategoryRepository extends CrudRepository<CategoryDTO,Integer> {

    @Query(value = "SELECT * FROM category ct" +
            " RIGHT JOIN product pr ON ct.id = pr.type" +
            " WHERE ct.id = :type ")
    ArrayList<ProductDTO> findListProductByIdCategory(@Param("type") Integer id);


}
