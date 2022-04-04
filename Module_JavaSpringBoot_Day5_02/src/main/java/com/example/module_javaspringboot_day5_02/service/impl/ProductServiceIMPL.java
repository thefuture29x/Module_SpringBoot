package com.example.module_javaspringboot_day5_02.service.impl;

import com.example.module_javaspringboot_day5_02.dto.ProductDTO;
import com.example.module_javaspringboot_day5_02.repository.IProductRepository;
import com.example.module_javaspringboot_day5_02.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceIMPL implements IProductService {
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return iProductRepository.save(productDTO);
    }

    @Override
    public void delete(Integer id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Iterable<ProductDTO> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<ProductDTO> findById(Integer id) {
        return iProductRepository.findById(id);
    }

    @Override
    public ProductDTO findByName(String search) {
        return iProductRepository.findByName(search);
    }
}
