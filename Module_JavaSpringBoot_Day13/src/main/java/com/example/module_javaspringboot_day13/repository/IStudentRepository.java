package com.example.module_javaspringboot_day13.repository;

import com.example.module_javaspringboot_day13.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity,Long> {
    @Query(value = "SELECT s FROM StudentEntity s " +
            "WHERE s.title LIKE '%:search%' " +
            "OR s.publisher LIKE '%:search%' " +
            "OR s.e LIKE '%:search%' ")
    StudentEntity searchStudent (@Param("search") String search);

//    StudentEntity findByTitleOrPublisherOrE(String search);
}
