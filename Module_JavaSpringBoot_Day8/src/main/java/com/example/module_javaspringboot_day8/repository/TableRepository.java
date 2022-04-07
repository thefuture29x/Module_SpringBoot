package com.example.module_javaspringboot_day8.repository;

import com.example.module_javaspringboot_day8.entities.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<TableEntity,Long> {
}
