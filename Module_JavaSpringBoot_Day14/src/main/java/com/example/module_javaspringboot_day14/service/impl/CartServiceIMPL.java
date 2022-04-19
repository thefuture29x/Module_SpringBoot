package com.example.module_javaspringboot_day14.service.impl;

import com.example.module_javaspringboot_day14.entities.CartEntity;
import com.example.module_javaspringboot_day14.entities.ProductEntity;
import com.example.module_javaspringboot_day14.repository.CartRepository;
import com.example.module_javaspringboot_day14.repository.ProductRepository;
import com.example.module_javaspringboot_day14.service.BaseService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartServiceIMPL implements BaseService<CartEntity> {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<CartEntity> findAll(DataFetchingEnvironment dataFetchingEnvironment) {
        int page = dataFetchingEnvironment.getArgument("page");
        int size = dataFetchingEnvironment.getArgument("size");
        Pageable pageable = PageRequest.of(page,size);
        Page<CartEntity> entityList = cartRepository.findAll(pageable);

        return entityList;
    }

    public Page<CartEntity> search(DataFetchingEnvironment dataFetchingEnvironment) {
        int page = dataFetchingEnvironment.getArgument("page");
        int size = dataFetchingEnvironment.getArgument("size");
        String search = dataFetchingEnvironment.getArgument("search");
        Pageable pageable = PageRequest.of(page,size);
        Page<CartEntity> entityList = cartRepository.searchCartProduct(search,pageable);

        return entityList;
    }

    @Override
    public CartEntity saveOrUpdate(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id_product");
        ProductEntity productEntity = productRepository.getById(id);
        CartEntity cartEntity = CartEntity.builder()
                .id(null)
                .idUser(1L)
                .idProduct(id)
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .amountCart(1).build();
        return cartRepository.save(cartEntity);

    }

    @Override
    public CartEntity find(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id_prduct");
        return cartRepository.getById(id);
    }

    public List<CartEntity> findCartProductOfUser(DataFetchingEnvironment dataFetchingEnvironment){
        Long id = dataFetchingEnvironment.getArgument("id_user");
        return cartRepository.findByIdUser(id);
    }


    @Override
    public CartEntity delete(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id_user");
        cartRepository.deleteByIdUser(id);
        return null;
    }

    @Override
    public CartEntity get(DataFetchingEnvironment dataFetchingEnvironment) {
        return null;
    }
}
