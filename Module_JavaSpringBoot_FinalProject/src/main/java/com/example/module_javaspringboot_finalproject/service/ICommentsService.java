package com.example.module_javaspringboot_finalproject.service;

import com.example.module_javaspringboot_finalproject.dto.CommentsDTO;

import java.util.List;

public interface ICommentsService {
    CommentsDTO save(CommentsDTO commentsDTO);
    List<CommentsDTO> getListCommentsByIdProduct(Long id);
    int countComments(Long id);
    int countCommentsByPoint(Long id_product,int point);
    int avgPoint(Long id_product);
}
