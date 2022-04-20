package com.example.module_javaspingboot_day16_02_practicejpa.specification;

import com.example.module_javaspingboot_day16_02_practicejpa.dto.ClassRoomDTO;
import com.example.module_javaspingboot_day16_02_practicejpa.entities.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import static com.example.module_javaspingboot_day16_02_practicejpa.entities.StudentEntity_.CLASS_ROOM_ENTITY;

public final class ClassRoomSpecification {

    public static Specification<StudentEntity> findByIdClassRoom(Long id_classroom) {
        return (root, query, cb) -> cb.equal(root.get(StudentEntity_.CLASS_ROOM_ENTITY), id_classroom);
    }

    public static Specification<ClassRoomDTO> findById(Long id) {
        return (root, query, cb) -> cb.equal(root.get(ClassRoomEntity_.ID), id);
    }
//    public static Specification<ClassRoomEntity> joinTable(Long id) {
////        return (root, query, cb) -> {
////            cb.like(cb.lower(root.join(StudentEntity_.CLASS_ROOM_ENTITY).get(ClassRoomEntity_.ID), id));
////        }
//        return (root, query, builder) -> {
//            final Join<ClassRoomEntity, StudentEntity> classrooom = root.join(ClassRoomEntity_.ID, JoinType.LEFT);
//            return builder.or(
//                    builder.like(builder.lower(classrooom.get(CLASS_ROOM_ENTITY)), id)
//                    );
//        }
//    }




}
