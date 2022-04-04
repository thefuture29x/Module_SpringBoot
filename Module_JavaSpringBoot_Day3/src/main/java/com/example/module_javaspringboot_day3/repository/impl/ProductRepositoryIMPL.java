package com.example.module_javaspringboot_day3.repository.impl;

import com.example.module_javaspringboot_day3.data.ProductDATA;
import com.example.module_javaspringboot_day3.dto.ProductDTO;
import com.example.module_javaspringboot_day3.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProductRepositoryIMPL implements IProductRepository {
    final ProductDATA productDATA;

    ArrayList<ProductDTO> productDTOArrayList;

    public ProductRepositoryIMPL(ProductDATA productDATA) {
        this.productDATA = productDATA;
        productDTOArrayList = this.productDATA.createData();
    }

    @Override
    public ArrayList<ProductDTO> save(ProductDTO productDTO) {
        boolean checkID = false;
        int max_id = 0;
        for (int i = 0; i < productDTOArrayList.size(); i++) {
            if (productDTOArrayList.get(i).getId() == productDTO.getId()){
                productDTOArrayList.set(i,productDTO);
                checkID = true;
            }
            max_id = i+2;
        }

        if (checkID == false){
            productDTO.setId(max_id);
            productDTOArrayList.add(productDTO);
        }

        return productDTOArrayList;
    }

    @Override
    public ArrayList<ProductDTO> delete(Integer id) {
        ArrayList<ProductDTO> arrayList = productDTOArrayList;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getId() == id){
                arrayList.remove(i);
                break;
            }
        }
        return arrayList;
    }

    @Override
    public ArrayList<ProductDTO> findAll() {
        ArrayList<ProductDTO> arrayList = new ArrayList<>();
        for (ProductDTO prductDTO :
                productDTOArrayList) {
            arrayList.add(prductDTO);
        }
        return arrayList;
    }

    @Override
    public ProductDTO findById(Integer id) {
        ProductDTO productDTO = new ProductDTO();
        ArrayList<ProductDTO> arrayList = productDTOArrayList;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getId() == id){
                productDTO = arrayList.get(i);
                break;
            }
        }
        return productDTO;
    }
}
