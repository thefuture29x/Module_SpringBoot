package com.example.module_javaspringboot_day10.service.impl;

import com.example.module_javaspringboot_day10.dto.ClassRoomDTO;
import com.example.module_javaspringboot_day10.entities.ClassRoomEntity;
import com.example.module_javaspringboot_day10.entities.StudentEntity;
import com.example.module_javaspringboot_day10.modal.ClassRoomModal;
import com.example.module_javaspringboot_day10.modal.StudentModal;
import com.example.module_javaspringboot_day10.repository.IStudentRepository;
import com.example.module_javaspringboot_day10.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceIMPL implements IStudentService {
    @Autowired
    IStudentRepository iStudentRepository;
    @Override
    public Boolean save(StudentModal studentModal) {
        try{
            if (studentModal.getId() == null){
                iStudentRepository.save(StudentModal.toEntity(studentModal));
            }else {
                List<ClassRoomEntity> entities = iStudentRepository.getById(studentModal.getId()).getClassRoomEntityList();
                for (ClassRoomModal classModal: studentModal.getClassRoomModalList()) {
                    entities.add(ClassRoomModal.toEntity(classModal));
                }
                StudentEntity entity = StudentModal.toEntity(studentModal);

                entity.setClassRoomEntityList(entities);
                iStudentRepository.save(entity);
            }

            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<StudentModal> findAll(Pageable pageable) {
        List<StudentModal> modals = new ArrayList<>();
        for (StudentEntity entitys: iStudentRepository.findAll(pageable)) {
            List<ClassRoomModal> classModal = new ArrayList<>();
            for (ClassRoomEntity entityList : entitys.getClassRoomEntityList()) {
                classModal.add(ClassRoomEntity.toModal(entityList));
            }
            StudentModal modal = StudentEntity.toModal(entitys);
            modal.setClassRoomModalList(classModal);
            modals.add(modal);
        }
        return modals;
    }

    @Override
    public void delete(Long id) {
        StudentEntity entitys = iStudentRepository.getById(id);
        iStudentRepository.delete(entitys);
    }

    @Override
    public StudentModal findById(Long id) {
        StudentEntity entitys = iStudentRepository.getById(id);
        return StudentEntity.toModal(entitys);
    }

    @Override
    public void deletes(Long[] ids) {
        for (Long id: ids) {
            StudentEntity entitys = iStudentRepository.getById(id);
            iStudentRepository.delete(entitys);
        }
    }
}
