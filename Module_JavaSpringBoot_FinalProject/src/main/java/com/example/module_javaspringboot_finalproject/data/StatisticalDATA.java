package com.example.module_javaspringboot_finalproject.data;

import com.example.module_javaspringboot_finalproject.dto.ProductDTO;
import com.example.module_javaspringboot_finalproject.dto.StatisticalDTO;
import com.example.module_javaspringboot_finalproject.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StatisticalDATA {
    @Autowired
    IProductService iProductService;

    public ArrayList<StatisticalDTO> createData(){

        ArrayList<StatisticalDTO> arrayList = new ArrayList<>();
        List<ProductDTO> dtoList = iProductService.findAllProduct();
        dtoList.stream().forEach(pro -> {
            StatisticalDTO statisticalDTO = new StatisticalDTO();
            statisticalDTO.setName(pro.getName());
            statisticalDTO.setAmountImport(pro.getAmount());
//            statisticalDTO.setAmountSold(statisticalDTO.getAmountSold());
            statisticalDTO.setAmountSold(0);
//            statisticalDTO.setTurnover(statisticalDTO.getTurnover());
            statisticalDTO.setTurnover(0);
            statisticalDTO.setSale(pro.getOldPrice() - pro.getNewPrice());
            statisticalDTO.setSoldPrice(pro.getNewPrice());
            statisticalDTO.setSoldImprot(pro.getImportPrice()* statisticalDTO.getAmountImport());
//            statisticalDTO.setTurnoverReal(statisticalDTO.getTurnoverReal());
            statisticalDTO.setTurnoverReal(0 - statisticalDTO.getSoldImprot());
            statisticalDTO.setTotal(0 - statisticalDTO.getSoldImprot());

            arrayList.add(statisticalDTO);
        });
        return arrayList;
    }
}
