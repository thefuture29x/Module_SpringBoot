package com.example.module_javaspringboot_day8.convert;

import com.example.module_javaspringboot_day8.dto.TimeBookTableDTO;
import com.example.module_javaspringboot_day8.entities.TimeBookTableEntity;
import org.springframework.stereotype.Component;

@Component
public class TimeBookTableConvert {
    public TimeBookTableEntity toEntity(TimeBookTableDTO dto){
        TimeBookTableEntity entity = new TimeBookTableEntity();
        entity.setId(dto.getId());
        entity.setTimeStart(dto.getTimeStart());
        entity.setTimeEnd(dto.getTimeEnd());
        entity.setTableEntity(dto.getTableEntity());
        return entity;
    }

    public TimeBookTableDTO toDTO(TimeBookTableEntity entity){
        TimeBookTableDTO dto = new TimeBookTableDTO();
        dto.setId(entity.getId());
        dto.setTimeStart(entity.getTimeStart());
        dto.setTimeEnd(entity.getTimeEnd());
        dto.setTableEntity(entity.getTableEntity());
        return dto;
    }
    public TimeBookTableEntity toEntity(TimeBookTableEntity entity,TimeBookTableDTO dto){
        entity.setId(dto.getId());
        entity.setTimeStart(dto.getTimeStart());
        entity.setTimeEnd(dto.getTimeEnd());
        entity.setTableEntity(dto.getTableEntity());
        return entity;
    }
}
