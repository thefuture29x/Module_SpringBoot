package com.example.module_javaspingboot_day15.repository;

import com.example.module_javaspingboot_day15.dto.InforDTO;
import com.example.module_javaspingboot_day15.entities.TeacherEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface TeacherRepository extends ReactiveCrudRepository<TeacherEntity,Long> {

    @Query("SELECT tc.id as id, tc.name as name,tc.id_classroom as id_classroom , cl.name as name_classroom FROM teacher tc " +
            "JOIN classroom cl ON cl.id = tc.id_classroom ")
    Flux<InforDTO> findAllTeacher();// lấy toàn bộ thông tin trả về khi join hai bảng, ép kiểu vè InforDTO

    @Query("SELECT tc.* FROM teacher tc " +
            "JOIN classroom cl ON cl.id = tc.id_classroom ")
    Flux<TeacherEntity> findAllTeacherEntity();// lấy toàn bộ thông tin Teacher trả về khi join hai bảng


    @Query("SELECT tc.* FROM teacher tc " +
            "JOIN classroom cl ON cl.id = tc.id_classroom ")
    Flux<TeacherEntity> findAllTC(Pageable pageable);

    Flux<TeacherEntity> findAllBy(Pageable pageable);// lấy toàn bộ thông tin Teacher trả về và phân trang theo pageable

    @Query("SELECT tc.* FROM teacher tc where tc.id_classroom = :id_classroom")
    Flux<TeacherEntity> findById_classroom(@Param(value = "id_classroom") Long id);// lấy danh sách Teacher thuộc ClassRoom có id_classroom tương ứng




}
