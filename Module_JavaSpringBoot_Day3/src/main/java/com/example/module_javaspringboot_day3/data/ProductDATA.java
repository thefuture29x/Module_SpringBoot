package com.example.module_javaspringboot_day3.data;

import com.example.module_javaspringboot_day3.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductDATA {
    public ArrayList<ProductDTO> createData(){
        ArrayList<ProductDTO> arrayList = new ArrayList<>();
        arrayList.add(new ProductDTO(1,"Product 1","1000","pr1.jpg"));
        arrayList.add(new ProductDTO(2,"Product 2","1000","pr2.jpg"));
        arrayList.add(new ProductDTO(3,"Product 3","1000","pr3.jpg"));
        arrayList.add(new ProductDTO(4,"Product 4","1000","pr4.jpg"));
        arrayList.add(new ProductDTO(5,"Product 5","1000","pr5.jpg"));
        arrayList.add(new ProductDTO(6,"Product 6","1000","pr6.jpg"));
        return arrayList;
    }

}
