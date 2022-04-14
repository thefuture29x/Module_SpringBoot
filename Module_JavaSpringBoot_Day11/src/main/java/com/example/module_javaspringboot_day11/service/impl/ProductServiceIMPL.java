package com.example.module_javaspringboot_day11.service.impl;

import com.example.module_javaspringboot_day11.entities.CategoryEntity;
import com.example.module_javaspringboot_day11.entities.DetailCategoryEntity;
import com.example.module_javaspringboot_day11.entities.DetailImagesEntity;
import com.example.module_javaspringboot_day11.entities.ProductEntity;
import com.example.module_javaspringboot_day11.modal.CategoryModal;
import com.example.module_javaspringboot_day11.modal.DetailCategoryModal;
import com.example.module_javaspringboot_day11.modal.DetailImagesModal;
import com.example.module_javaspringboot_day11.modal.ProductModal;
import com.example.module_javaspringboot_day11.repository.*;
import com.example.module_javaspringboot_day11.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceIMPL implements IProductService {
    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Autowired
    IDetailCategoryRepository iDetailCategoryRepository;
    @Autowired
    IDetailImagesRepository iDetailImagesRepository;
    @Autowired
    IDetailProductRepository iDetailProductRepository;

    @Override
    public List<ProductModal> findAll(Pageable pageable) {
        List<ProductModal> productModalList = new ArrayList<>();
        Page<ProductEntity> productEntityList = iProductRepository.findAll(pageable);
        for (ProductEntity entitys :
                productEntityList) {
            ProductModal modal = ProductEntity.toModal(entitys);
            modal.setCategoryModalID(entitys.getCategoryEntity().getId());
            modal.setDetailCategoryModalID(entitys.getDetailCategoryEntity().getId());
            modal.setDetailProductModalID(entitys.getDetailProductEntity().getId());
            List<Long> detailImagesModalListID = new ArrayList<>();
            for (DetailImagesEntity detailEntity :
                    entitys.getDetailImagesEntityList()) {
                detailImagesModalListID.add(detailEntity.getId());
            }
            modal.setDetailImagesModalListID(detailImagesModalListID);

            productModalList.add(modal);
        }
        return productModalList;
    }

    @Override
    public List<ProductModal> findAll(CategoryModal modal) {
        List<ProductModal> productModalList = new ArrayList<>();
        CategoryEntity entity = CategoryModal.toEntity(modal);
        List<ProductEntity> productEntityList = iProductRepository.findByCategoryEntity(entity);
        for (ProductEntity entitys :
                productEntityList) {
            ProductModal modal2 = ProductEntity.toModal(entitys);
            modal2.setCategoryModalID(entitys.getCategoryEntity().getId());
            modal2.setDetailCategoryModalID(entitys.getDetailCategoryEntity().getId());
            modal2.setDetailProductModalID(entitys.getDetailProductEntity().getId());
            List<Long> detailImagesModalListID = new ArrayList<>();
            for (DetailImagesEntity detailEntity :
                    entitys.getDetailImagesEntityList()) {
                detailImagesModalListID.add(detailEntity.getId());
            }
            modal2.setDetailImagesModalListID(detailImagesModalListID);

            productModalList.add(modal2);
        }
        return productModalList;
    }

    @Override
    public List<ProductModal> findAll(DetailCategoryModal modal) {
        List<ProductModal> productModalList = new ArrayList<>();
        DetailCategoryEntity entity = DetailCategoryModal.toEntity(modal);
        List<ProductEntity> productEntityList = iProductRepository.findByDetailCategoryEntity(entity);
        for (ProductEntity entitys :
                productEntityList) {
            ProductModal modal2 = ProductEntity.toModal(entitys);
            modal2.setCategoryModalID(entitys.getCategoryEntity().getId());
            modal2.setDetailCategoryModalID(entitys.getDetailCategoryEntity().getId());
            modal2.setDetailProductModalID(entitys.getDetailProductEntity().getId());
            List<Long> detailImagesModalListID = new ArrayList<>();
            for (DetailImagesEntity detailEntity :
                    entitys.getDetailImagesEntityList()) {
                detailImagesModalListID.add(detailEntity.getId());
            }
            modal2.setDetailImagesModalListID(detailImagesModalListID);

            productModalList.add(modal2);
        }
        return productModalList;
    }

    @Override
    public List<ProductModal> search(String search) {
        List<ProductModal> productModalList = new ArrayList<>();
        List<ProductEntity> productEntityList = iProductRepository.searchByName(search);
        for (ProductEntity entitys :
                productEntityList) {
            ProductModal modal2 = ProductEntity.toModal(entitys);
            modal2.setCategoryModalID(entitys.getCategoryEntity().getId());
            modal2.setDetailCategoryModalID(entitys.getDetailCategoryEntity().getId());
            modal2.setDetailProductModalID(entitys.getDetailProductEntity().getId());
            List<Long> detailImagesModalListID = new ArrayList<>();
            for (DetailImagesEntity detailEntity :
                    entitys.getDetailImagesEntityList()) {
                detailImagesModalListID.add(detailEntity.getId());
            }
            modal2.setDetailImagesModalListID(detailImagesModalListID);

            productModalList.add(modal2);
        }
        return productModalList;
    }

    @Override
    public List<ProductModal> findCartProduct(List<Long> ids) {
        List<ProductModal> productModalList = new ArrayList<>();
        for (Long id :ids) {
            ProductEntity entitys = iProductRepository.getById(id);
            ProductModal modal2 = new ProductModal(entitys.getId(), entitys.getName(), entitys.getOldPrice(), entitys.getNewPrice(), null,null,null,null);
            modal2.setCategoryModalID(entitys.getCategoryEntity().getId());
            modal2.setDetailCategoryModalID(entitys.getDetailCategoryEntity().getId());
            modal2.setDetailProductModalID(entitys.getDetailProductEntity().getId());
            List<Long> detailImagesModalListID = new ArrayList<>();
            for (DetailImagesEntity detailEntity :
                    entitys.getDetailImagesEntityList()) {
                detailImagesModalListID.add(detailEntity.getId());
            }
            modal2.setDetailImagesModalListID(detailImagesModalListID);

            productModalList.add(modal2);
        }
        return productModalList;
    }

    @Override
    public ProductModal save2(ProductModal productModal) {
        ProductEntity entity = ProductModal.toEntity(productModal);
        entity.setCategoryEntity(iCategoryRepository.getById(productModal.getCategoryModalID()));
        entity.setDetailCategoryEntity(iDetailCategoryRepository.getById(productModal.getDetailCategoryModalID()));
        entity.setDetailProductEntity(iDetailProductRepository.getById(productModal.getDetailProductModalID()));


        ProductEntity productEntity = iProductRepository.save(entity);
        ProductModal newProductModal = new ProductModal();
        newProductModal.setId(productEntity.getId());
        newProductModal.setNewPrice(productEntity.getNewPrice());
        newProductModal.setOldPrice(productEntity.getOldPrice());
        newProductModal.setName(productEntity.getName());



        return newProductModal;
    }

    @Override
    public List<ProductModal> findAll() {
        return null;
    }

    @Override
    public boolean save(ProductModal productModal) {
        ProductEntity entity = ProductModal.toEntity(productModal);
        entity.setCategoryEntity(iCategoryRepository.getById(productModal.getCategoryModalID()));
        entity.setDetailCategoryEntity(iDetailCategoryRepository.getById(productModal.getDetailCategoryModalID()));
        entity.setDetailProductEntity(iDetailProductRepository.getById(productModal.getDetailProductModalID()));


        List<DetailImagesEntity> list =  new ArrayList<>();
        List<Long> imagesModalList = productModal.getDetailImagesModalListID();
        if (imagesModalList != null){
            for (Long id_images : imagesModalList) {
                list.add(iDetailImagesRepository.getById(id_images));
            }
        }else {
            list.add(new DetailImagesEntity());
        }

        entity.setDetailImagesEntityList(list);

        iProductRepository.save(entity);

        return true;
    }

    @Override
    public void delete(Long aLong) {
//        ProductEntity entity = iProductRepository.getById(aLong);
//        iDetailProductRepository.deleteByProductEntity(entity);
        iProductRepository.deleteById(aLong);
    }

    @Override
    public ProductModal findById(Long aLong) {
        ProductEntity entitys = iProductRepository.getById(aLong);
//        ProductModal modal = ProductEntity.toModal(entitys);
        ProductModal modal = new ProductModal();
        modal.setId(aLong);
        modal.setName(entitys.getName());
        modal.setNewPrice(entitys.getNewPrice());
        modal.setOldPrice(entitys.getOldPrice());

        modal.setCategoryModalID(entitys.getCategoryEntity().getId());
        modal.setDetailCategoryModalID(entitys.getDetailCategoryEntity().getId());
        modal.setDetailProductModalID(entitys.getDetailProductEntity().getId());
        List<Long> detailImagesModalListID = new ArrayList<>();
        for (DetailImagesEntity detailEntity :
                entitys.getDetailImagesEntityList()) {
            detailImagesModalListID.add(detailEntity.getId());
        }
        modal.setDetailImagesModalListID(detailImagesModalListID);

        return modal;
    }
}
