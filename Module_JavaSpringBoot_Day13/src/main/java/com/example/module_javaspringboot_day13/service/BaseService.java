package com.example.module_javaspringboot_day13.service;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.List;

public interface BaseService<T> extends DataFetcher<T> {
    List<T> findAll(DataFetchingEnvironment dataFetchingEnvironment);
    T saveOrUpdate(DataFetchingEnvironment dataFetchingEnvironment);
    T find(DataFetchingEnvironment dataFetchingEnvironment);
    T delete (DataFetchingEnvironment dataFetchingEnvironment);
}
