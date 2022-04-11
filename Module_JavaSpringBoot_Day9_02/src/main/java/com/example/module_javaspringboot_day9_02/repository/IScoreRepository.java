package com.example.module_javaspringboot_day9_02.repository;

import com.example.module_javaspringboot_day9_02.entities.ScoreEntity;
import com.example.module_javaspringboot_day9_02.entities.StudentEntity;
import com.example.module_javaspringboot_day9_02.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IScoreRepository extends JpaRepository<ScoreEntity,Long> {
    List<ScoreEntity> findAllByStudentEntity(StudentEntity entity);
    ScoreEntity findBySubjectEntity(SubjectEntity subjectEntity);
}
