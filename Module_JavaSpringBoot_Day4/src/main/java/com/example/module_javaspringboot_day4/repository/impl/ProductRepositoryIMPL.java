package com.example.module_javaspringboot_day4.repository.impl;

import com.example.module_javaspringboot_day4.data.CategoryDATA;
import com.example.module_javaspringboot_day4.data.ProductDATA;
import com.example.module_javaspringboot_day4.data.UserDATA;
import com.example.module_javaspringboot_day4.dto.CategoryDTO;
import com.example.module_javaspringboot_day4.dto.ProductDTO;
import com.example.module_javaspringboot_day4.dto.UserDTO;
import com.example.module_javaspringboot_day4.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepositoryIMPL implements IProductRepository {
    final ProductDATA productDATA;
    final CategoryDATA categoryDATA;
    final UserDATA userDATA;
    

    ArrayList<ProductDTO> listProduct;
    ArrayList<CategoryDTO> listCategory;
    ArrayList<UserDTO> listUser;


    public ProductRepositoryIMPL(ProductDATA productDATA, CategoryDATA categoryDATA, UserDATA userDATA) {
        this.productDATA = productDATA;
        this.categoryDATA = categoryDATA;
        this.userDATA = userDATA;
        listProduct = this.productDATA.createProductData();
        listCategory = this.categoryDATA.createCategoryDATA();
        listUser = this.userDATA.createUserData();
    }

    @Override
    public ArrayList<ProductDTO> save(ProductDTO productDTO) {
        boolean checkPr = false;
        int max_id = 0;


        productDTO.setStatus(1);
        productDTO.setCreateTime(""+LocalDate.now());
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == productDTO.getId()){
                listProduct.set(i,productDTO);
                checkPr = true;
            }
            max_id = i+2;
        }

        if (checkPr == false){
            productDTO.setId(max_id);
            listProduct.add(productDTO);
        }
        return listProduct;
    }

    @Override
    public ArrayList<ProductDTO> delete(Integer id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == id){
                listProduct.remove(i);
                break;
            }
        }
        return listProduct;
    }

    @Override
    public ArrayList<ProductDTO> findAll() {
        return listProduct;
    }

    @Override
    public ProductDTO findById(Integer id) {
        ProductDTO productDTO = new ProductDTO();
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == id){
                productDTO = listProduct.get(i);
                break;
            }
        }
        return productDTO;
    }

    @Override
    public ArrayList<ProductDTO> findByName(String search) {
        ArrayList<ProductDTO> productDTOS = new ArrayList<>();
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getName().equals(search)){
                productDTOS.add(listProduct.get(i));
            }
        }
        return productDTOS;
    }

}
