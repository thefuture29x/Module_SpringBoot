package com.example.module_javaspringboot_day9.repository;

import com.example.module_javaspringboot_day9.entities.RegistSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegistSubjectRepositoty extends JpaRepository<RegistSubjectEntity,Long> {
}
