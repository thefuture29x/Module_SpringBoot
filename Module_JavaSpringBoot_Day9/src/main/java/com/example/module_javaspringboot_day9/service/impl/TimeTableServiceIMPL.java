package com.example.module_javaspringboot_day9.service.impl;

import com.example.module_javaspringboot_day9.convert.SubjectConvert;
import com.example.module_javaspringboot_day9.convert.TimeTableConvert;
import com.example.module_javaspringboot_day9.dto.RegistSubjectDTO;
import com.example.module_javaspringboot_day9.dto.ScoreDTO;
import com.example.module_javaspringboot_day9.dto.SubjectDTO;
import com.example.module_javaspringboot_day9.dto.TimeTableDTO;
import com.example.module_javaspringboot_day9.entities.StudentEntity;
import com.example.module_javaspringboot_day9.entities.TimeTableEntity;
import com.example.module_javaspringboot_day9.repository.IStudentRepository;
import com.example.module_javaspringboot_day9.repository.ISubjectRepository;
import com.example.module_javaspringboot_day9.repository.ITimeTableRepository;
import com.example.module_javaspringboot_day9.service.IScoreService;
import com.example.module_javaspringboot_day9.service.ISubjectService;
import com.example.module_javaspringboot_day9.service.ITimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.ext.DeclHandler;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeTableServiceIMPL implements ITimeTableService {
    @Autowired
    ITimeTableRepository TimeTableRepository;
    @Autowired
    TimeTableConvert TimeTableConvert;
    @Autowired
    IStudentRepository iStudentRepository;
    @Autowired
    IScoreService iScoreService;
    @Autowired
    ISubjectService iSubjectService;
    @Autowired
    ISubjectRepository iSubjectRepository;
    @Autowired
    SubjectConvert subjectConvert;

    @Override
    public List<TimeTableDTO> findAll() {
        List<TimeTableDTO> dtoList = new ArrayList<>();
        for (TimeTableEntity entity: TimeTableRepository.findAll()) {
            dtoList.add(TimeTableConvert.toDTO(entity));
        }
        return dtoList;
    }

    @Override
    public void saveOrUpdate(TimeTableDTO TimeTableDTO) {

        if (TimeTableDTO.getId() == null){
            TimeTableEntity oldEntity = TimeTableConvert.toEntity(TimeTableDTO);
            StudentEntity studentEntity = iStudentRepository.getById(TimeTableDTO.getId_timeTable());
            oldEntity.setStudentTimeTable(iStudentRepository.getById(TimeTableDTO.getId_timeTable()));
            TimeTableRepository.save(oldEntity);
        }else {
            TimeTableEntity oldEntity = TimeTableRepository.getById(TimeTableDTO.getId());
            TimeTableEntity newEntity = TimeTableConvert.toEntity(oldEntity,TimeTableDTO);
            newEntity.setStudentTimeTable(iStudentRepository.getById(oldEntity.getId()));
            TimeTableRepository.save(newEntity);
        }
    }

    @Override
    public TimeTableDTO findById(Long id) {
        return TimeTableConvert.toDTO(TimeTableRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        TimeTableRepository.deleteById(id);
    }

    @Override
    public List<TimeTableDTO> findAllByIdStudent(Long id_student) {
        List<TimeTableDTO> dtoList = new ArrayList<>();
        for (TimeTableEntity entity: TimeTableRepository.findAllByStudentTimeTable(iStudentRepository.getById(id_student))) {
            TimeTableDTO dto = new TimeTableDTO();
            dto = TimeTableConvert.toDTO(entity);
            dto.setListScore(iScoreService.findAllByIdStudent(id_student));
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<SubjectDTO> getListSubject(){

        List<SubjectDTO> subjectDTOList = iSubjectService.findAll();
        List<SubjectDTO> newListSubject = new ArrayList<>();
        for (int i = 0; i < subjectDTOList.size(); i++) {
            if (!subjectDTOList.get(i).getName().equals(findTimeTableByNameSubject(subjectDTOList.get(i).getName()))){
                ScoreDTO scoreDTO = iScoreService.findById(subjectDTOList.get(i).getId_score());
                SubjectDTO subjectDTO = subjectDTOList.get(i);
                subjectDTO.setScoreDTO(scoreDTO);

                newListSubject.add(subjectDTO);
            }

        }


        return newListSubject;
    }

    @Override
    public SubjectDTO findTimeTableByNameSubject(String subject_name){
        SubjectDTO subjectDTO = subjectConvert.toDTO(iSubjectRepository.findByName(subject_name));
        return subjectDTO;
    }


}
