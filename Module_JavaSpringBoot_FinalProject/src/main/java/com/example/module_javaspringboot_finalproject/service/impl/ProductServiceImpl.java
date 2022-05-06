package com.example.module_javaspringboot_finalproject.service.impl;

import com.example.module_javaspringboot_finalproject.dto.CategoryDTO;
import com.example.module_javaspringboot_finalproject.dto.ProductDTO;
import com.example.module_javaspringboot_finalproject.entities.CategoryEntity;
import com.example.module_javaspringboot_finalproject.entities.ProductEntity;
import com.example.module_javaspringboot_finalproject.entities.UserEntity;
import com.example.module_javaspringboot_finalproject.repository.CategoryRepository;
import com.example.module_javaspringboot_finalproject.repository.ProductRepository;
import com.example.module_javaspringboot_finalproject.repository.UserRepository;
import com.example.module_javaspringboot_finalproject.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<ProductDTO> findAllProduct(Pageable pageable) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        productRepository.findAll(pageable).forEach(pro ->{
            ProductDTO dto = ProductEntity.toDTO(pro);
            CategoryDTO categoryDTO = CategoryEntity.toDTO(categoryRepository.getById(pro.getCategoryEntity().getId()));
            dto.setCategoryDTO(categoryDTO);
            productDTOList.add(dto);
        });

        return productDTOList;
    }

    @Override
    public List<ProductDTO> findAllProduct() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        productRepository.findAll().stream().forEach(pro ->{
            ProductDTO dto = ProductEntity.toDTO(pro);
            CategoryDTO categoryDTO = CategoryEntity.toDTO(categoryRepository.getById(pro.getCategoryEntity().getId()));
            dto.setCategoryDTO(categoryDTO);
            productDTOList.add(dto);
        });
        return productDTOList;
    }

    @Override
    public ProductDTO findById(Long id) {
        ProductEntity entity = productRepository.findById(id).get();
        ProductDTO dto = ProductEntity.toDTO(entity);
        dto.setCategoryDTO(CategoryEntity.toDTO(categoryRepository.getById(entity.getCategoryEntity().getId())));
        return dto;
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        String replaceFileName = fileName.replaceAll("\\s+", "");
        String uploadDir = "./src/main/resources/static/images/";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(replaceFileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return replaceFileName;
    }

    @Override
    public ProductDTO saveOrUpdate(ProductDTO dto) {
        ProductEntity productEntity = ProductDTO.toEntity(dto);
        productEntity.setCategoryEntity(categoryRepository.findById(dto.getCategoryDTO().getId()).get());

        if (dto.getId() != null){
            if (dto.getImage().equals("")){
                productEntity.setImage(productRepository.findById(dto.getId()).get().getImage());
            }
        }else{
            if (dto.getImage().equals("")){
                productEntity.setImage("default_image.png");
            }
        }

        return ProductEntity.toDTO(productRepository.save(productEntity));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void setAmountProduct(Long id_product, int amount) {
        ProductEntity productEntity = productRepository.findById(id_product).get();
        productEntity.setAmount(productEntity.getAmount() - amount);
        productRepository.save(productEntity);
    }
}
