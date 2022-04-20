package com.example.module_javaspingboot_day16_02_practicejpa.repository;

import com.example.module_javaspingboot_day16_02_practicejpa.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICustomerRepository extends JpaRepository<CustomerEntity,Long>, JpaSpecificationExecutor<CustomerEntity> {
}
