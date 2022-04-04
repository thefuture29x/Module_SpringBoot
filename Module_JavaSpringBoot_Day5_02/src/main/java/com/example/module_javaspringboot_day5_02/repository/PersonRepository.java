package com.example.module_javaspringboot_day5_02.repository;

import com.example.module_javaspringboot_day5_02.dto.PersonDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonDTO, Integer> {
}
