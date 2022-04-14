package com.example.module_javaspringboot_day11.service;

import java.util.List;

public interface BaseService<T,V>{
    List<T> findAll();
    boolean save(T t);
    void delete(V v);
    T findById(V v);
}
