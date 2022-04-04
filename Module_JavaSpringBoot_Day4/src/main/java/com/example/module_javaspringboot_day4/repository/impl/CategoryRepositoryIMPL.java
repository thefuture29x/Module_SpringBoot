package com.example.module_javaspringboot_day4.repository.impl;

import com.example.module_javaspringboot_day4.data.CategoryDATA;
import com.example.module_javaspringboot_day4.data.ProductDATA;
import com.example.module_javaspringboot_day4.data.UserDATA;
import com.example.module_javaspringboot_day4.dto.CategoryDTO;
import com.example.module_javaspringboot_day4.dto.ProductDTO;
import com.example.module_javaspringboot_day4.dto.UserDTO;
import com.example.module_javaspringboot_day4.repository.ICategoryRepository;
import com.example.module_javaspringboot_day4.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class CategoryRepositoryIMPL implements ICategoryRepository {
    final ProductDATA productDATA;
    final CategoryDATA categoryDATA;
    final UserDATA userDATA;

    ArrayList<ProductDTO> listProduct;
    ArrayList<CategoryDTO> listCategory;
    ArrayList<UserDTO> listUser;

    public CategoryRepositoryIMPL(ProductDATA productDATA, CategoryDATA categoryDATA, UserDATA userDATA) {
        this.productDATA = productDATA;
        this.categoryDATA = categoryDATA;
        this.userDATA = userDATA;
        listProduct = this.productDATA.createProductData();
        listCategory = this.categoryDATA.createCategoryDATA();
        listUser = this.userDATA.createUserData();
    }

    @Override
    public ArrayList<CategoryDTO> save(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public ArrayList<CategoryDTO> delete(Integer id) {
        return null;
    }

    @Override
    public ArrayList<CategoryDTO> findAll() {
        for (int i = 0; i < listCategory.size(); i++) {
            listCategory.get(i).setListProduct(findListProductById(listCategory.get(i).getId()));
        }
        return listCategory;
    }

    @Override
    public ArrayList<ProductDTO> findListProductById(Integer id) {
        ArrayList<ProductDTO> listPr = new ArrayList<>();
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getType() == id){
                listPr.add(listProduct.get(i));
            }
        }
        return listPr;
    }

    @Override
    public CategoryDTO findById(Integer id) {
        return null;
    }
}
