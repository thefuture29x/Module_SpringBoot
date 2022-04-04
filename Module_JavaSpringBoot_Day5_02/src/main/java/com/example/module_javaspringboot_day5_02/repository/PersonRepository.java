package com.example.module_javaspringboot_day5_02.repository;

import com.example.module_javaspringboot_day5_02.dto.PersonDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<PersonDTO, Integer> {
//    public List<PersonDTO> findAll(Pageable pageable);

//    @Query(value = "select p from person p order by p.id desc limit: pageable")
//    List<PersonDTO> findAll(@Param("pageable") Pageable pageable);
//
//    @Query(value = "select p from person p order by p.id desc limit :offset , :limit")
//    Page<PersonDTO> findAll(@Param("offset") int offset,@Param("limit") int limit );
}
