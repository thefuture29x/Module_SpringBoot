package com.example.module_javaspringboot_finalproject.service;

import com.example.module_javaspringboot_finalproject.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAllProduct(Pageable pageable);
    List<ProductDTO> findAllProduct();
    ProductDTO findById(Long id);
    String uploadFile(MultipartFile multipartFile);
    ProductDTO saveOrUpdate(ProductDTO dto);
    void delete(Long id);
    void setAmountProduct(Long id_product, int amount);
}
