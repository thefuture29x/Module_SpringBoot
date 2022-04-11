package com.example.module_javaspringboot_day9.repository;

import com.example.module_javaspringboot_day9.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<StudentEntity,Long> {
}
