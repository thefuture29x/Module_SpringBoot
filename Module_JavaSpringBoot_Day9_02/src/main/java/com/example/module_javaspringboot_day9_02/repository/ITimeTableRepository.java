package com.example.module_javaspringboot_day9_02.repository;

import com.example.module_javaspringboot_day9_02.entities.StudentEntity;
import com.example.module_javaspringboot_day9_02.entities.TimeTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITimeTableRepository extends JpaRepository<TimeTableEntity,Long> {
    List<TimeTableEntity> findAllByStudentTimeTable(StudentEntity entity);
}
