package com.example.module_javaspingboot_day15.repository;

import com.example.module_javaspingboot_day15.entities.ClassRoomEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
@Repository
public interface ClassRoomRepository extends ReactiveCrudRepository<ClassRoomEntity,Long> {
//    Flux<ClassRoomEntity> findAllBy(Pageable pageable);
}
