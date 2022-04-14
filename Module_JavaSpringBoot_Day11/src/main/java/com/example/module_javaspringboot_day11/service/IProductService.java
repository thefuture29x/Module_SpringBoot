package com.example.module_javaspringboot_day11.service;

import com.example.module_javaspringboot_day11.modal.CategoryModal;
import com.example.module_javaspringboot_day11.modal.DetailCategoryModal;
import com.example.module_javaspringboot_day11.modal.ProductModal;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends BaseService<ProductModal,Long>{
    ProductModal save2(ProductModal productModal);
    List<ProductModal> findAll(Pageable pageable);
    List<ProductModal> findAll(CategoryModal modal);
    List<ProductModal> findAll(DetailCategoryModal modal);
    List<ProductModal> search(String search);
    List<ProductModal> findCartProduct(List<Long> ids);
}
