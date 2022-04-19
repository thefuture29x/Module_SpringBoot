package com.example.module_javaspringboot_day14_02.service.impl;

import com.example.module_javaspringboot_day14_02.dto.CategoryDTO;
import com.example.module_javaspringboot_day14_02.dto.ProductDTO;
import com.example.module_javaspringboot_day14_02.entities.CategoryEntity;
import com.example.module_javaspringboot_day14_02.entities.ProductEntity;
import com.example.module_javaspringboot_day14_02.repository.ICategoryRepository;
import com.example.module_javaspringboot_day14_02.repository.IProductRepository;
import com.example.module_javaspringboot_day14_02.service.ICategoryService;
import com.example.module_javaspringboot_day14_02.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceIMPL implements IProductService<ProductDTO, Long> {
    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    ICategoryService iCategoryService;
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<ProductDTO> findAll(Pageable pageable) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (ProductEntity entities : iProductRepository.findAll(pageable)) {
            ProductDTO productDTO = ProductEntity.toDTO(entities);
            CategoryDTO categoryDTO = (CategoryDTO) iCategoryService.findById(entities.getId());
            productDTO.setCategoryDTO(categoryDTO);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public boolean save(ProductDTO productDTO) {
        ProductEntity productEntity = ProductDTO.toEntity(productDTO);
        if (productDTO.getCategoryDTO() != null){
            CategoryEntity categoryEntity = CategoryEntity.builder()
                    .id(productDTO.getCategoryDTO().getId())
                    .name(productDTO.getCategoryDTO().getName())
                    .build();
            productEntity.setCategoryEntity(categoryEntity);

        }else{
            productEntity.setCategoryEntity(iCategoryRepository.getById(1L));
        }

        productEntity.setModifiedBy();
        productEntity.setModifiedDate();
        productEntity.setCreatedBy();
        productEntity.setCreatedDate();

        iProductRepository.save(productEntity);
        return true;

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public ProductDTO findById(Long aLong) {
        return null;
    }
}
