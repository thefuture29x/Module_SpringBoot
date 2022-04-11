package com.example.module_javaspringboot_day9_02.service.impl;

import com.example.module_javaspringboot_day9_02.convert.SubjectConvert;
import com.example.module_javaspringboot_day9_02.dto.RegistSubjectDTO;
import com.example.module_javaspringboot_day9_02.dto.SubjectDTO;
import com.example.module_javaspringboot_day9_02.dto.TimeTableDTO;
import com.example.module_javaspringboot_day9_02.entities.SubjectEntity;
import com.example.module_javaspringboot_day9_02.repository.IScoreRepository;
import com.example.module_javaspringboot_day9_02.repository.ISubjectRepository;
import com.example.module_javaspringboot_day9_02.service.IRegistSubjectService;
import com.example.module_javaspringboot_day9_02.service.ISubjectService;
import com.example.module_javaspringboot_day9_02.service.ITimeTableService;
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
    @Autowired
    IRegistSubjectService iRegistSubjectService;
    @Autowired
    ITimeTableService iTimeTableService;

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
            return SubjectConvert.toDTO(SubjectRepository.save(SubjectConvert.toEntity(SubjectDTO)));
        }else {
            SubjectEntity oldEntity = SubjectRepository.getById(SubjectDTO.getId());
            SubjectEntity newEntity = SubjectConvert.toEntity(oldEntity,SubjectDTO);

            return SubjectConvert.toDTO(SubjectRepository.save(newEntity));
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
    public List<SubjectDTO> getListSubject() {
        return null;
    }

    @Override
    public SubjectDTO findTimeTableByNameSubject(String subject_name) {
        return null;
    }

    @Override
    public SubjectDTO registSubject(Long id_subject) {
        RegistSubjectDTO registSubjectDTO = iRegistSubjectService.findById(id_subject);

        TimeTableDTO timeTableDTO = new TimeTableDTO();

        timeTableDTO.setId(null);
        timeTableDTO.setStatus("In Process");
//        timeTableDTO.setId_timeTable(1L);// Default id_Student = 1L
        Long id_timeTablr = iTimeTableService.saveOrUpdate(timeTableDTO).getId();

        SubjectDTO subjectDTO = new SubjectDTO();

        subjectDTO.setId(null);
        subjectDTO.setName(registSubjectDTO.getName());
        subjectDTO.setTime(registSubjectDTO.getTime());
        return null;
    }
}
