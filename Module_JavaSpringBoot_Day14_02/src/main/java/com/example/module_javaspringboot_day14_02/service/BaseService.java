package com.example.module_javaspringboot_day14_02.service;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<T,ID> {
    List<T> findAll(Pageable pageable);
    boolean save(T t);
    void delete(ID id);
    T findById(ID id);
}
