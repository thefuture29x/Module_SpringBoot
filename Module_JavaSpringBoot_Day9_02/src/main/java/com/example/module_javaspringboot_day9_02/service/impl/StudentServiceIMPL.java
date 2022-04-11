package com.example.module_javaspringboot_day9_02.service.impl;

import com.example.module_javaspringboot_day9_02.convert.StudentConvert;
import com.example.module_javaspringboot_day9_02.dto.StudentDTO;
import com.example.module_javaspringboot_day9_02.entities.StudentEntity;
import com.example.module_javaspringboot_day9_02.repository.IStudentRepository;
import com.example.module_javaspringboot_day9_02.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceIMPL implements IStudentService {

    @Autowired
    IStudentRepository StudentRepository;
    @Autowired
    StudentConvert StudentConvert;

    @Override
    public List<StudentDTO> findAll() {
        List<StudentDTO> dtoList = new ArrayList<>();
        for (StudentEntity entity: StudentRepository.findAll()) {
            dtoList.add(StudentConvert.toDTO(entity));
        }
        return dtoList;
    }

    @Override
    public StudentDTO saveOrUpdate(StudentDTO StudentDTO) {
        if (StudentDTO.getId() == null){
            return StudentConvert.toDTO(StudentRepository.save(StudentConvert.toEntity(StudentDTO)));
        }else {
            StudentEntity oldEntity = StudentRepository.getById(StudentDTO.getId());
            StudentEntity newEntity = StudentConvert.toEntity(oldEntity,StudentDTO);
            return StudentConvert.toDTO(StudentRepository.save(newEntity));
        }
    }

    @Override
    public StudentDTO findById(Long id) {
        return StudentConvert.toDTO(StudentRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        StudentRepository.deleteById(id);
    }
}
