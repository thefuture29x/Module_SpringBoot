package com.example.module_javaspringboot_day9.repository;

import com.example.module_javaspringboot_day9.entities.ScoreEntity;
import com.example.module_javaspringboot_day9.entities.StudentEntity;
import com.example.module_javaspringboot_day9.entities.TimeTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IScoreRepository extends JpaRepository<ScoreEntity,Long> {
//    List<TimeTableEntity> findAllByStudentTimeTable(StudentEntity entity);
    List<ScoreEntity> findAllByStudentEntity(StudentEntity entity);
}
