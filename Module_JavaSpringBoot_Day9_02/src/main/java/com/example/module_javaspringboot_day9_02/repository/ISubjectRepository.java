package com.example.module_javaspringboot_day9_02.repository;

import com.example.module_javaspringboot_day9_02.entities.ScoreEntity;
import com.example.module_javaspringboot_day9_02.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectRepository extends JpaRepository<SubjectEntity,Long> {
    SubjectEntity findByName(String name);
}
