package com.example.module_javaspringboot_day14.service;

import com.example.module_javaspringboot_day14.entities.ProductEntity;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseService<T> extends DataFetcher<T> {
    Page<T> findAll(DataFetchingEnvironment dataFetchingEnvironment);
    T saveOrUpdate(DataFetchingEnvironment dataFetchingEnvironment);
    T find(DataFetchingEnvironment dataFetchingEnvironment);
    T delete (DataFetchingEnvironment dataFetchingEnvironment);
}
