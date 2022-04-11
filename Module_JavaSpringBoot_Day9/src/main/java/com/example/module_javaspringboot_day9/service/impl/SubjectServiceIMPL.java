package com.example.module_javaspringboot_day9.service.impl;

import com.example.module_javaspringboot_day9.convert.SubjectConvert;
import com.example.module_javaspringboot_day9.dto.InforDTO;
import com.example.module_javaspringboot_day9.dto.ScoreDTO;
import com.example.module_javaspringboot_day9.dto.SubjectDTO;
import com.example.module_javaspringboot_day9.entities.SubjectEntity;
import com.example.module_javaspringboot_day9.repository.IScoreRepository;
import com.example.module_javaspringboot_day9.repository.ISubjectRepository;
import com.example.module_javaspringboot_day9.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceIMPL implements ISubjectService {
    @Autowired
    ISubjectRepository SubjectRepository;
    @Autowired
    SubjectConvert SubjectConvert;
    @Autowired
    IScoreRepository iScoreRepository;

    @Override
    public List<SubjectDTO> findAll() {
        List<SubjectDTO> dtoList = new ArrayList<>();
        for (SubjectEntity entity: SubjectRepository.findAll()) {
            dtoList.add(SubjectConvert.toDTO(entity));
        }

        return dtoList;
    }

    @Override
    public SubjectDTO saveOrUpdate(SubjectDTO SubjectDTO) {
        if (SubjectDTO.getId() == null){
            SubjectEntity newSubject = SubjectConvert.toEntity(SubjectDTO);
            newSubject.setScoreEntity(iScoreRepository.getById(SubjectDTO.getId_score()));
            return SubjectConvert.toDTO(SubjectRepository.save(newSubject));
        }else {
            SubjectEntity oldEntity = SubjectRepository.getById(SubjectDTO.getId());
            SubjectEntity newEntity = SubjectConvert.toEntity(oldEntity,SubjectDTO);
            newEntity.setScoreEntity(iScoreRepository.getById(SubjectDTO.getId_score()));
            return  SubjectConvert.toDTO(SubjectRepository.save(newEntity));
        }
    }

    @Override
    public SubjectDTO findById(Long id) {
        return SubjectConvert.toDTO(SubjectRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        SubjectRepository.deleteById(id);
    }

    @Override
    public Long lastIDSubject() {
        int size = findAll().size();
        if (size == 0){
            return 0L;
        }else {
            return findAll().get(size-1).getId();
        }

    }

    public InforDTO getInforSubject(){

        return null;
    }


}
