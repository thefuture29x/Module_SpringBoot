package com.example.module_javaspringboot_day10_02.service;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<T> {
    public Boolean save(T t);
    public List<T> findAll(Pageable pageable);
    public T findById(Long id);
    public void delete(Long[] ids);
}
