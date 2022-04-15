package com.example.module_javaspringboot_day13.service.impl;

import com.example.module_javaspringboot_day13.entities.ClassEntity;
import com.example.module_javaspringboot_day13.repository.IClassRepository;
import com.example.module_javaspringboot_day13.service.BaseService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceIMPL implements BaseService<ClassEntity> {
    @Autowired
    IClassRepository iClassRepository;

    @Override
    public List<ClassEntity> findAll(DataFetchingEnvironment dataFetchingEnvironment) {
        List<ClassEntity> list = iClassRepository.findAll();
        return list;
    }

    public Page<ClassEntity> findAllWithPage(DataFetchingEnvironment dataFetchingEnvironment) {
        int page = dataFetchingEnvironment.getArgument("page");
        int size = dataFetchingEnvironment.getArgument("size");
        String sortBy = dataFetchingEnvironment.getArgument("sortBy");
        String order = dataFetchingEnvironment.getArgument("order");
//        Sort sort1 = new Sort();
        Pageable pageable = PageRequest.of(page, size);

        Page<ClassEntity> pageab = iClassRepository.findAll(pageable);
        return pageab;
    }

    @Override
    public ClassEntity saveOrUpdate(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id");
        String name = dataFetchingEnvironment.getArgument("name");
        if (id == null){
            return iClassRepository.save(new ClassEntity(id,name,null));
        }else {
            ClassEntity classEntity = iClassRepository.getById(id);
            classEntity.setName(name);
            return iClassRepository.save(classEntity);
        }
    }

    @Override
    public ClassEntity find(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id");
        return iClassRepository.findById(id).get();
    }

    @Override
    public ClassEntity delete(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id");
        iClassRepository.deleteById(id);
        return null;
    }

    @Override
    public ClassEntity get(DataFetchingEnvironment dataFetchingEnvironment) {
        return null;
    }
}
