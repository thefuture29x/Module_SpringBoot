package com.example.module_javaspringboot_day3.repository;

import com.example.module_javaspringboot_day3.dto.TestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestDTO,Long> {

}
