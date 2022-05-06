package com.example.module_javaspringboot_finalproject.repository;

import com.example.module_javaspringboot_finalproject.data.StatisticalDATA;
import com.example.module_javaspringboot_finalproject.dto.StatisticalDTO;
import com.example.module_javaspringboot_finalproject.entities.SoldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SoldRepository extends JpaRepository<SoldEntity,Long> {

}
