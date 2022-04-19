package com.example.module_javaspringboot_day14.repository;

import com.example.module_javaspringboot_day14.entities.CartEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity,Long> {
    List<CartEntity> findByIdUser(Long id);
    void deleteByIdUser(Long id);

    @Query(value = "select ct from CartEntity ct where " +
            "ct.name like %:search% or " +
            "ct.description like %:search% ")
    Page<CartEntity> searchCartProduct(@Param(value = "search") String search, Pageable pageable);
}
