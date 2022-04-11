package com.example.module_javaspringboot_day9_02.service.impl;


import com.example.module_javaspringboot_day9_02.convert.*;
import com.example.module_javaspringboot_day9_02.dto.ScoreDTO;
import com.example.module_javaspringboot_day9_02.dto.SubjectDTO;
import com.example.module_javaspringboot_day9_02.dto.TimeTableDTO;
import com.example.module_javaspringboot_day9_02.entities.ScoreEntity;
import com.example.module_javaspringboot_day9_02.entities.SubjectEntity;
import com.example.module_javaspringboot_day9_02.entities.TimeTableEntity;
import com.example.module_javaspringboot_day9_02.repository.IScoreRepository;
import com.example.module_javaspringboot_day9_02.repository.IStudentRepository;
import com.example.module_javaspringboot_day9_02.repository.ITimeTableRepository;
import com.example.module_javaspringboot_day9_02.service.ITimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeTableServiceIMPL implements ITimeTableService {
    @Autowired
    ITimeTableRepository iTimeTableRepository;
    @Autowired
    IStudentRepository iStudentRepository;
    @Autowired
    IScoreRepository iScoreRepository;
    @Autowired
    TimeTableConvert timeTableConvert;
    @Autowired
    StudentConvert studentConvert;
    @Autowired
    SubjectConvert subjectConvert;
    @Autowired
    RegistSubjectConvert registSubjectConvert;
    @Autowired
    ScoreConvert scoreConvert;

    @Override
    public List<TimeTableDTO> findAll() {
        return null;
    }

    @Override
    public TimeTableDTO saveOrUpdate(TimeTableDTO timeTableDTO) {
        return null;
    }

    @Override
    public TimeTableDTO findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long ids) {

    }

    @Override
    public List<TimeTableDTO> findAllByIdStudent(Long id_student) {
        List<TimeTableDTO> dtoList = new ArrayList<>();
        for (TimeTableEntity timeEntitys : iTimeTableRepository.findAllByStudentTimeTable(iStudentRepository.getById(id_student))) {
            TimeTableDTO timeTableDTO = timeTableConvert.toDTO(timeEntitys);
            timeTableDTO.setStudentDTO(studentConvert.toDTO(timeEntitys.getStudentTimeTable()));
            timeTableDTO.setRegistSubjectDTO(registSubjectConvert.toDTO(timeEntitys.getRegistSubjectEntity()));

            SubjectDTO subjectDTO = subjectConvert.toDTO(timeEntitys.getSubjectEntity());
            ScoreDTO scoreDTO = scoreConvert.toDTO(iScoreRepository.findBySubjectEntity(timeEntitys.getSubjectEntity()));
            subjectDTO.setScoreDTO(scoreDTO);

            timeTableDTO.setSubjectDTO(subjectDTO);
            dtoList.add(timeTableDTO);
        }
        return dtoList;
    }
}
