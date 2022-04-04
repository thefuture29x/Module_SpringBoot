package com.example.module_javaspringboot_day5_02.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;

@Table(value = "category")
public class CategoryDTO {
    @Id
    private int id;
    @Column
    private String name;

//    private ArrayList<ProductDTO> listProduct;

    public CategoryDTO() {
    }

//    public CategoryDTO(int id, String name, ArrayList<ProductDTO> listProduct) {
//        this.id = id;
//        this.name = name;
//        this.listProduct = listProduct;
//    }

    public CategoryDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public ArrayList<ProductDTO> getListProduct() {
//        return listProduct;
//    }
//
//    public void setListProduct(ArrayList<ProductDTO> listProduct) {
//        this.listProduct = listProduct;
//    }


}
