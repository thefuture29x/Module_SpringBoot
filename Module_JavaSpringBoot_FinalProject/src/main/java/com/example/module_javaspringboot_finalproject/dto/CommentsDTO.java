package com.example.module_javaspringboot_finalproject.dto;

import com.example.module_javaspringboot_finalproject.entities.CommentsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDTO {
    private Long id;
    private String content;
    private int point;
    private String createDate;

    private ProductDTO productDTOComments;

    private UserDTO userDTO;

    public static CommentsEntity toEntity(CommentsDTO dto){
        return CommentsEntity.builder()
                .id(dto.id)
                .content(dto.content)
                .point(dto.point)
//                .idParent(dto.idParent)
//                .idChild(dto.idChild)
                .build();
    }
}
