package com.example.module_javaspringboot_day13.service.impl;

import com.example.module_javaspringboot_day13.entities.ClassEntity;
import com.example.module_javaspringboot_day13.entities.TeacherEntity;
import com.example.module_javaspringboot_day13.repository.IClassRepository;
import com.example.module_javaspringboot_day13.repository.ITeacherRepository;
import com.example.module_javaspringboot_day13.service.BaseService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceIMPL implements BaseService<TeacherEntity> {
    @Autowired
    ITeacherRepository teacherRepository;
    @Autowired
    IClassRepository iClassRepository;

    @Override
    public List<TeacherEntity> findAll(DataFetchingEnvironment dataFetchingEnvironment) {
        return teacherRepository.findAll();
    }

    @Override
    public TeacherEntity saveOrUpdate(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id");
        Long id_class = dataFetchingEnvironment.getArgument("id_class");
        String name = dataFetchingEnvironment.getArgument("name");
        if (id == null){
            return teacherRepository.save(new TeacherEntity(id,name,iClassRepository.getById(id_class)));
        }else {
            TeacherEntity teacherEntity = teacherRepository.getById(id);
            teacherEntity.setName(name);
            teacherEntity.setClassEntity(iClassRepository.getById(id_class));
            return teacherRepository.save(teacherEntity);
        }
    }

    @Override
    public TeacherEntity find(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id");
        return teacherRepository.getById(id);
    }

    @Override
    public TeacherEntity delete(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id");
        teacherRepository.deleteById(id);
        return null;
    }

    @Override
    public TeacherEntity get(DataFetchingEnvironment dataFetchingEnvironment) {
        return null;
    }
}
