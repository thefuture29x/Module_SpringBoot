package com.example.module_javaspringboot_finalproject.service.impl;

import com.example.module_javaspringboot_finalproject.controller.AdminController;
import com.example.module_javaspringboot_finalproject.data.StatisticalDATA;
import com.example.module_javaspringboot_finalproject.dto.CartProductDTO;
import com.example.module_javaspringboot_finalproject.dto.ProductDTO;
import com.example.module_javaspringboot_finalproject.dto.SoldDTO;
import com.example.module_javaspringboot_finalproject.dto.StatisticalDTO;
import com.example.module_javaspringboot_finalproject.entities.SoldEntity;
import com.example.module_javaspringboot_finalproject.repository.ProductRepository;
import com.example.module_javaspringboot_finalproject.repository.SoldRepository;
import com.example.module_javaspringboot_finalproject.service.IProductService;
import com.example.module_javaspringboot_finalproject.service.ISoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoldServiceImpl implements ISoldService {
    @Autowired
    SoldRepository soldRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    IProductService iProductService;

    public final StatisticalDATA statisticalDATA;

    public final List<StatisticalDTO> listStatistic;


    public SoldServiceImpl(StatisticalDATA statisticalDATA) {
        this.statisticalDATA = statisticalDATA;
        listStatistic = this.statisticalDATA.createData();
    }

    @Override
    public SoldDTO save(SoldDTO soldDTO) {
        SoldEntity entity = SoldDTO.toEntity(soldDTO);
        entity.setProducSoldtEntity(productRepository.findById(soldDTO.getProductDTO().getId()).get());
        return SoldEntity.toDTO(soldRepository.save(entity));
    }

    @Override
    public List<StatisticalDTO> setDataStatistic(CartProductDTO pro){
        listStatistic.stream().forEach(sta -> {
            if (sta.getName().equals(pro.getName())) {
                sta.setAmountSold(sta.getAmountSold() + pro.getAmountCart());
                sta.setTurnover(sta.getTurnover() + (pro.getAmountCart() * pro.getNewPrice()));
                sta.setTurnoverReal(sta.getTurnover() - sta.getSoldImprot());
                sta.setTotal(sta.getTurnover() - sta.getSoldImprot());
            }
        });
        return listStatistic;

    }

    @Override
    public List<StatisticalDTO> getListStatistic(){
        return listStatistic;
    }

}
