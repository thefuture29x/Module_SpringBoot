package com.example.module_javaspingboot_day15.repository;

import com.example.module_javaspingboot_day15.dto.InforDTO;
import com.example.module_javaspingboot_day15.entities.TeacherEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface TeacherRepository extends ReactiveCrudRepository<TeacherEntity,Long> {

    @Query("SELECT tc.id as id, tc.name as name,tc.id_classroom as id_classroom , cl.name as name_classroom FROM teacher tc " +
            "JOIN classroom cl ON cl.id = tc.id_classroom ")
    Flux<InforDTO> findAllTeacher();

    @Query("SELECT tc.* FROM teacher tc " +
            "JOIN classroom cl ON cl.id = tc.id_classroom ")
    Flux<TeacherEntity> findAllTeacherEntity();


    @Query("SELECT tc.* FROM teacher tc " +
            "JOIN classroom cl ON cl.id = tc.id_classroom ")
    Flux<TeacherEntity> findAllTC(Pageable pageable);

    Flux<TeacherEntity> findAllBy(Pageable pageable);


}
