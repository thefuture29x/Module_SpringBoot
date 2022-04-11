package com.example.module_javaspringboot_day9.repository;

import com.example.module_javaspringboot_day9.entities.StudentEntity;
import com.example.module_javaspringboot_day9.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectRepository extends JpaRepository<SubjectEntity,Long> {
    SubjectEntity findByName(String name);
}
