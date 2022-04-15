package com.example.module_javaspringboot_day13.repository;

import com.example.module_javaspringboot_day13.entities.ClassEntity;
import com.example.module_javaspringboot_day13.entities.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRepository extends JpaRepository<ClassEntity,Long> {

}
