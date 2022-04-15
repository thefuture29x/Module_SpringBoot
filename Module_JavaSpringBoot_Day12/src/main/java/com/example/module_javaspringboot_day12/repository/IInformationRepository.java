package com.example.module_javaspringboot_day12.repository;

import com.example.module_javaspringboot_day12.dto.InformationDTO;
import com.example.module_javaspringboot_day12.entities.SchoolEntity;
import com.example.module_javaspringboot_day12.modal.InformationModal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IInformationRepository extends JpaRepository<SchoolEntity,Long> {
    @Query("select new com.example.module_javaspringboot_day12.modal.InformationModal(s.id,s.name,sc.name,tc.name) from SchoolEntity s " +
            "inner join SchoolClassEntity sc on sc.schoolEntity.id = s.id " +
            "inner join TeacherEntity tc on sc.teacherEntity.id = tc.id ")
    List<InformationModal> getAllInformation();

    @Query("select new com.example.module_javaspringboot_day12.modal.InformationModal(s.id,s.name,sc.name,tc.name) from SchoolEntity s " +
            "inner join SchoolClassEntity sc on sc.schoolEntity.id = s.id " +
            "inner join TeacherEntity tc on sc.teacherEntity.id = tc.id ")
    Page<InformationModal> getAllInformationWithPage(Pageable pageable);
}
