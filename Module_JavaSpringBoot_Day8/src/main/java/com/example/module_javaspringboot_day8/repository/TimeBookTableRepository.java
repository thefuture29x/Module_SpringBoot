package com.example.module_javaspringboot_day8.repository;

import com.example.module_javaspringboot_day8.entities.TimeBookTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeBookTableRepository extends JpaRepository<TimeBookTableEntity,Long> {
}
