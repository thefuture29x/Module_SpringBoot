package com.example.module_javaspringboot_day13.repository;

import com.example.module_javaspringboot_day13.entities.StudentEntity;
import com.example.module_javaspringboot_day13.entities.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends JpaRepository<TeacherEntity,Long> {

}
