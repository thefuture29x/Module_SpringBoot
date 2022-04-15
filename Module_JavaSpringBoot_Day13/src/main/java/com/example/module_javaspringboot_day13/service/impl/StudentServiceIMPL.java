package com.example.module_javaspringboot_day13.service.impl;

import com.example.module_javaspringboot_day13.entities.StudentEntity;
import com.example.module_javaspringboot_day13.repository.IStudentRepository;
import com.example.module_javaspringboot_day13.service.BaseService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIMPL implements BaseService<StudentEntity> {
    @Autowired
    IStudentRepository iStudentRepository;

    @Override
    public List<StudentEntity> findAll(DataFetchingEnvironment dataFetchingEnvironment) {
        return iStudentRepository.findAll();
    }

    @Override
    public StudentEntity saveOrUpdate(DataFetchingEnvironment dataFetchingEnvironment) {
        Long isn = dataFetchingEnvironment.getArgument("id");

        String title = dataFetchingEnvironment.getArgument("title");
        String publisher = dataFetchingEnvironment.getArgument("publisher");
        String e = dataFetchingEnvironment.getArgument("e");
        return iStudentRepository.save(new StudentEntity(isn, title, publisher, e));
    }

    @Override
    public StudentEntity find(DataFetchingEnvironment dataFetchingEnvironment) {
        Long isn = dataFetchingEnvironment.getArgument("id");
        return iStudentRepository.getById(isn);
    }

    @Override
    public StudentEntity delete(DataFetchingEnvironment dataFetchingEnvironment) {
        Long isn = dataFetchingEnvironment.getArgument("id");
        iStudentRepository.deleteById(isn);
        return null;
    }

    @Override
    public StudentEntity get(DataFetchingEnvironment dataFetchingEnvironment) {
        return null;
    }
}
