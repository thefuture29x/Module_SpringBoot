package com.example.module_javaspringboot_finalproject.service.impl;

import com.example.module_javaspringboot_finalproject.dto.CommentsDTO;
import com.example.module_javaspringboot_finalproject.entities.CommentsEntity;
import com.example.module_javaspringboot_finalproject.entities.ProductEntity;
import com.example.module_javaspringboot_finalproject.entities.UserEntity;
import com.example.module_javaspringboot_finalproject.repository.CommentsRepository;
import com.example.module_javaspringboot_finalproject.repository.ProductRepository;
import com.example.module_javaspringboot_finalproject.repository.UserRepository;
import com.example.module_javaspringboot_finalproject.service.ICommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentsServiceImpl implements ICommentsService {
    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public CommentsDTO save(CommentsDTO commentsDTO) {
        CommentsEntity entity = CommentsDTO.toEntity(commentsDTO);
        entity.setCreatrDate(new Date());
        UserEntity userEntity = userRepository.findById(commentsDTO.getUserDTO().getId()).get();
        entity.setProductEntityComments(productRepository.getById(commentsDTO.getProductDTOComments().getId()));
        entity.setUserEntity(userEntity);
        return CommentsEntity.toDTO(commentsRepository.save(entity));
    }

    @Override
    public List<CommentsDTO> getListCommentsByIdProduct(Long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        List<CommentsEntity> entityList = commentsRepository.findByProductEntityComments(productEntity);
        List<CommentsDTO> dtoList = new ArrayList<>();
        entityList.stream().forEach(pro -> {
            CommentsDTO commentsDTO = CommentsEntity.toDTO(pro);
            UserEntity userEntity = pro.getUserEntity();
            commentsDTO.setUserDTO(UserEntity.toDTO(userEntity));
            dtoList.add(commentsDTO);
        });
        return dtoList;
    }

    @Override
    public int countComments(Long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        return commentsRepository.countCommentsEntityByProductEntityComments(productEntity);
    }

    @Override
    public int countCommentsByPoint(Long id_product, int point) {
        return commentsRepository.countCommentsEntityByPoint(id_product, point);
    }

    @Override
    public int avgPoint(Long id_product) {
        return commentsRepository.avgPoint(id_product);
    }
}
