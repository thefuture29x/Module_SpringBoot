package com.example.module_javaspringboot_day10.repository;

import com.example.module_javaspringboot_day10.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<StudentEntity,Long> {
}
