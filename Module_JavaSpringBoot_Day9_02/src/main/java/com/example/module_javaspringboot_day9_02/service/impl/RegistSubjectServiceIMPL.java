package com.example.module_javaspringboot_day9_02.service.impl;

import com.example.module_javaspringboot_day9_02.convert.RegistSubjectConvert;
import com.example.module_javaspringboot_day9_02.dto.RegistSubjectDTO;
import com.example.module_javaspringboot_day9_02.dto.SubjectDTO;
import com.example.module_javaspringboot_day9_02.dto.TimeTableDTO;
import com.example.module_javaspringboot_day9_02.entities.*;
import com.example.module_javaspringboot_day9_02.repository.*;
import com.example.module_javaspringboot_day9_02.service.IRegistSubjectService;
import com.example.module_javaspringboot_day9_02.service.ITimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RegistSubjectServiceIMPL implements IRegistSubjectService {
    @Autowired
    IRegistSubjectRepositoty RegistSubjectRepository;
    @Autowired
    RegistSubjectConvert RegistSubjectConvert;
    @Autowired
    ITimeTableService iTimeTableService;
    @Autowired
    IStudentRepository iStudentRepository;
    @Autowired
    IScoreRepository iScoreRepository;
    @Autowired
    ISubjectRepository iSubjectRepository;
    @Autowired
    ITimeTableRepository iTimeTableRepository;

    @Override
    public List<RegistSubjectDTO> findAll() {
        List<RegistSubjectDTO> dtoList = new ArrayList<>();
        for (RegistSubjectEntity entity: RegistSubjectRepository.findAll()) {
            dtoList.add(RegistSubjectConvert.toDTO(entity));
        }
        return dtoList;
    }

    @Override
    public RegistSubjectDTO saveOrUpdate(RegistSubjectDTO RegistSubjectDTO) {
        if (RegistSubjectDTO.getId() == null){
            return RegistSubjectConvert.toDTO(RegistSubjectRepository.save(RegistSubjectConvert.toEntity(RegistSubjectDTO)));
        }else {
            RegistSubjectEntity oldEntity = RegistSubjectRepository.getById(RegistSubjectDTO.getId());
            RegistSubjectEntity newEntity = RegistSubjectConvert.toEntity(oldEntity,RegistSubjectDTO);
            return RegistSubjectConvert.toDTO(RegistSubjectRepository.save(newEntity));
        }
    }

    @Override
    public RegistSubjectDTO findById(Long id) {
        return RegistSubjectConvert.toDTO(RegistSubjectRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        RegistSubjectRepository.deleteById(id);
    }

    @Override
    public List<RegistSubjectDTO> findListSubjectNoneRegist(Long id_student) {
        List<RegistSubjectDTO> dtoList = findAll();
        List<TimeTableDTO> dtTimeTable = iTimeTableService.findAllByIdStudent(id_student);
        List<RegistSubjectDTO> listSubjectNoneRegist = new ArrayList<>();
        for (int i = 0; i < dtoList.size(); i++) {
            boolean check = false;
            for (int j = 0; j < dtTimeTable.size(); j++) {
                if (dtoList.get(i).getName().equals(dtTimeTable.get(j).getSubjectDTO().getName())){
                    check = true;
                }
            }
            if (check == false){
                listSubjectNoneRegist.add(dtoList.get(i));
            }
        }

        return listSubjectNoneRegist;

    }

    @Override
    public void studentRegistSubject(Long id_student, Long id_subject) {
        RegistSubjectEntity registSubjectEntity = RegistSubjectRepository.getById(id_subject);
        StudentEntity studentEntity = iStudentRepository.getById(id_student);

        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setId(null);
        scoreEntity.setProcessScore(0);
        scoreEntity.setTestScore(0);
        scoreEntity.setFinalScore(0);
        scoreEntity.setStudentEntity(studentEntity);

        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setId(null);
        subjectEntity.setName(registSubjectEntity.getName());
        subjectEntity.setTime(registSubjectEntity.getTime());
        subjectEntity.setScoreEntity(iScoreRepository.save(scoreEntity));

        SubjectEntity saveSubject = iSubjectRepository.save(subjectEntity);

        TimeTableEntity timeTableEntity = new TimeTableEntity();
        timeTableEntity.setId(null);
        timeTableEntity.setStatus("In Process");
        timeTableEntity.setStudentTimeTable(studentEntity);
        timeTableEntity.setRegistSubjectEntity(registSubjectEntity);
        timeTableEntity.setSubjectEntity(saveSubject);

        Set<SubjectEntity> newListSubject = new HashSet<>();
        for (SubjectEntity subs : studentEntity.getListSubject()) {
            newListSubject.add(subs);
        }
        newListSubject.add(saveSubject);
        studentEntity.setListSubject(newListSubject);


        iStudentRepository.save(studentEntity);
        iTimeTableRepository.save(timeTableEntity);

    }
}
