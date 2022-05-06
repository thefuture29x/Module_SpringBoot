package com.example.module_javaspringboot_finalproject.api;

import com.example.module_javaspringboot_finalproject.service.ICommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentsAPI {
    @Autowired
    ICommentsService iCommentsService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getComments(Long id){
        return ResponseEntity.ok().body(iCommentsService.getListCommentsByIdProduct(id));
    }
}
