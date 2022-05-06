package com.example.module_javaspringboot_finalproject.entities;

import com.example.module_javaspringboot_finalproject.dto.CommentsDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class CommentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @Column(name = "create_date")
    private Date creatrDate;

    private int point;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity userEntity;


    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductEntity productEntityComments;

    public static CommentsDTO toDTO(CommentsEntity entity){
        return CommentsDTO.builder()
                .id(entity.id)
                .content(entity.content)
                .point(entity.point)
                .createDate(entity.creatrDate.toString())
//                .idParent(entity.idParent)
//                .idChild(entity.idChild)
                .build();
    }
}
