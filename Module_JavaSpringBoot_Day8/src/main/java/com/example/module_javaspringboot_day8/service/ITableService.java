package com.example.module_javaspringboot_day8.service;

import com.example.module_javaspringboot_day8.dto.TableDTO;

import java.util.List;

public interface ITableService {
    List<TableDTO> findAll();
    void saveOrUpdate(TableDTO tableDTO);
    TableDTO  findById(Long id);
    Long[] delete(Long[] id);
}
