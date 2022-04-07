package com.example.module_javaspringboot_day8.convert;

import com.example.module_javaspringboot_day8.dto.TableDTO;
import com.example.module_javaspringboot_day8.entities.TableEntity;
import org.springframework.stereotype.Component;

@Component
public class TableConvert {
    public TableEntity toEntity(TableDTO dto){
        TableEntity entity = new TableEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setAmountSeat(dto.getAmountSeat());
        entity.setPrice(dto.getPrice());
        entity.setStatus(dto.getStatus());
        entity.setUserEntity(dto.getUserEntity());
        return entity;
    }

    public TableDTO toDTO(TableEntity entity){
        TableDTO dto = new TableDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setAmountSeat(entity.getAmountSeat());
        dto.setPrice(entity.getPrice());
        dto.setStatus(entity.getStatus());
        dto.setUserEntity(entity.getUserEntity());
        return dto;
    }
    public TableEntity toEntity(TableEntity entity,TableDTO dto){
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setAmountSeat(dto.getAmountSeat());
        entity.setPrice(dto.getPrice());
        entity.setStatus(dto.getStatus());
        entity.setUserEntity(dto.getUserEntity());
        return entity;
    }

}
