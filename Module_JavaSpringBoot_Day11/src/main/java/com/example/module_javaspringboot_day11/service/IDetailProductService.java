package com.example.module_javaspringboot_day11.service;

import com.example.module_javaspringboot_day11.modal.DetailProductModal;
import com.example.module_javaspringboot_day11.modal.ProductModal;

public interface IDetailProductService extends BaseService<DetailProductModal,Long>{
    public Long save2(DetailProductModal detailProductModal);
}
