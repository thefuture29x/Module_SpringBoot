package com.example.module_javaspringboot_finalproject.repository;

import com.example.module_javaspringboot_finalproject.entities.CategoryEntity;
import com.example.module_javaspringboot_finalproject.entities.CommentsEntity;
import com.example.module_javaspringboot_finalproject.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsEntity,Long> {
    List<CommentsEntity> findByProductEntityComments(ProductEntity productEntity);
    int countCommentsEntityByProductEntityComments(ProductEntity productEntity);
    @Query("SELECT COUNT(cm.point) FROM CommentsEntity cm WHERE cm.productEntityComments.id = :id_product AND cm.point = :point")
    int countCommentsEntityByPoint(@Param(value = "id_product") Long id_product,
                                   @Param(value = "point") int point);

    @Query("SELECT AVG(cm.point) FROM CommentsEntity cm WHERE cm.productEntityComments.id = :id_product")
    int avgPoint(@Param(value = "id_product") Long id_product);
}
