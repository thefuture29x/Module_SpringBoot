package com.example.module_javaspringboot_day8.service.impl;

import com.example.module_javaspringboot_day8.convert.TableConvert;
import com.example.module_javaspringboot_day8.dto.TableDTO;
import com.example.module_javaspringboot_day8.entities.TableEntity;
import com.example.module_javaspringboot_day8.repository.TableRepository;
import com.example.module_javaspringboot_day8.service.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableServiceIMPL implements ITableService {
    @Autowired
    TableRepository tableRepository;
    @Autowired
    TableConvert tableConvert;

    @Override
    public List<TableDTO> findAll() {
        List<TableDTO> dtoList = new ArrayList<>();
        for (TableEntity entity: tableRepository.findAll()) {
            dtoList.add(tableConvert.toDTO(entity));
        }
        return dtoList;
    }

    @Override
    public void saveOrUpdate(TableDTO tableDTO) {
        if (tableDTO.getId() == null){
            tableRepository.save(tableConvert.toEntity(tableDTO));
        }else {
            TableEntity oldEntity = tableRepository.getById(tableDTO.getId());
            TableEntity newEntity = tableConvert.toEntity(oldEntity,tableDTO);
            tableRepository.save(newEntity);
        }
    }

    @Override
    public TableDTO findById(Long id) {
        return tableConvert.toDTO(tableRepository.getById(id));
    }

    @Override
    public Long[] delete(Long[] id) {
        for (int i = 0; i < id.length; i++) {
            tableRepository.deleteById(id[i]);
        }
        return id;
    }

    public static void main(String[] args) {

    }
}
