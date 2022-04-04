package com.example.module_javaspringboot_day4.dto;

import java.util.ArrayList;

public class CategoryDTO {
    private int id;
    private String name;
    private ArrayList<ProductDTO> listProduct;

    public CategoryDTO() {
    }

    public CategoryDTO(int id, String name, ArrayList<ProductDTO> listProduct) {
        this.id = id;
        this.name = name;
        this.listProduct = listProduct;
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

    public ArrayList<ProductDTO> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<ProductDTO> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listProduct=" + listProduct +
                '}';
    }
}
