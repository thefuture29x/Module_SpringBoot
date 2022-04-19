package com.example.module_javaspringboot_day14.service.impl;

import com.example.module_javaspringboot_day14.entities.CartEntity;
import com.example.module_javaspringboot_day14.entities.ProductEntity;
import com.example.module_javaspringboot_day14.repository.ProductRepository;
import com.example.module_javaspringboot_day14.service.BaseService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceIMPL implements BaseService<ProductEntity> {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<ProductEntity> findAll(DataFetchingEnvironment dataFetchingEnvironment) {
        int page = dataFetchingEnvironment.getArgument("page");
        int size = dataFetchingEnvironment.getArgument("size");
        Pageable pageable = PageRequest.of(page,size);
        Page<ProductEntity> entityList = productRepository.findAll(pageable);
        return entityList;
    }

    @Override
    public ProductEntity saveOrUpdate(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id");
        String name = dataFetchingEnvironment.getArgument("name");
        String des = dataFetchingEnvironment.getArgument("description");
        int price = dataFetchingEnvironment.getArgument("price");
        int amount = dataFetchingEnvironment.getArgument("amount");
        if (id == null){
            return productRepository.save(new ProductEntity(null,name,price,des,10));
        }else{
            ProductEntity productEntity = productRepository.getById(id);
            productEntity.setName(name);
            productEntity.setPrice(price);
            productEntity.setDescription(des);
            productEntity.setAmount(amount);
            return productRepository.save(productEntity);
        }

    }

    @Override
    public ProductEntity find(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id");
        return productRepository.getById(id);
    }

    @Override
    public ProductEntity delete(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id");
        productRepository.deleteById(id);
        return null;
    }

    @Override
    public ProductEntity get(DataFetchingEnvironment dataFetchingEnvironment) {
        return null;
    }
}
