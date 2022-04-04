package com.example.module_javaspringboot_day4.data;

import com.example.module_javaspringboot_day4.dto.ProductDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class ProductDATA {

    public ArrayList<ProductDTO> createProductData(){
        ArrayList<ProductDTO> data = new ArrayList<>();
        data.add(new ProductDTO(1,"Product 1","pr1.jpg","1000",10,1,1,"2022-04-01","Phong"));
        data.add(new ProductDTO(2,"Product 2","pr2.jpg","1000",10,1,1,"2022-04-01","Phong"));
        data.add(new ProductDTO(3,"Product 3","pr3.jpg","1000",10,1,2,"2022-04-01","Phong"));
        data.add(new ProductDTO(4,"Product 4","pr4.jpg","1000",10,1,3,"2022-04-01","Phong"));
        data.add(new ProductDTO(5,"Product 5","pr5.jpg","1000",10,1,4,"2022-04-01","Phong"));
        data.add(new ProductDTO(6,"Product 6","pr6.jpg","1000",10,1,1,"2022-04-01","Phong"));
        data.add(new ProductDTO(7,"Product 7","pr1.jpg","1000",10,1,3,"2022-04-01","Phong"));
        data.add(new ProductDTO(8,"Product 8","pr2.jpg","1000",10,1,5,"2022-04-01","Phong"));
        data.add(new ProductDTO(9,"Product 9","pr3.jpg","1000",10,1,5,"2022-04-01","Phong"));
        data.add(new ProductDTO(10,"Product 10","pr4.jpg","1000",10,1,1,"2022-04-01","Phong"));
        data.add(new ProductDTO(11,"Product 11","pr5.jpg","1000",10,1,3,"2022-04-01","Phong"));
        data.add(new ProductDTO(12,"Product 12","pr6.jpg","1000",10,1,4,"2022-04-01","Phong"));

        return data;

    }
}
