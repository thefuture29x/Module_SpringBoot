package com.example.module_javaspringboot_finalproject.service;

import com.example.module_javaspringboot_finalproject.dto.CartProductDTO;
import com.example.module_javaspringboot_finalproject.dto.ProductDTO;
import com.example.module_javaspringboot_finalproject.dto.SoldDTO;
import com.example.module_javaspringboot_finalproject.dto.StatisticalDTO;

import java.util.List;

public interface ISoldService {
    SoldDTO save(SoldDTO soldDTO);
    List<StatisticalDTO> setDataStatistic(CartProductDTO pro);
    List<StatisticalDTO> getListStatistic();
}
