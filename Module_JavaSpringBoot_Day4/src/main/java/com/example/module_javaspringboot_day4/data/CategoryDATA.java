package com.example.module_javaspringboot_day4.data;

import com.example.module_javaspringboot_day4.dto.CategoryDTO;
import com.example.module_javaspringboot_day4.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CategoryDATA {
    public ArrayList<CategoryDTO> createCategoryDATA(){
        ArrayList<CategoryDTO> data = new ArrayList<>();
        data.add(new CategoryDTO(1,"Category 1",new ArrayList<ProductDTO>()));
        data.add(new CategoryDTO(2,"Category 2",new ArrayList<ProductDTO>()));
        data.add(new CategoryDTO(3,"Category 3",new ArrayList<ProductDTO>()));
        data.add(new CategoryDTO(4,"Category 4",new ArrayList<ProductDTO>()));
        data.add(new CategoryDTO(5,"Category 5",new ArrayList<ProductDTO>()));
        return data;
    }

}
