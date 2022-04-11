package com.example.module_javaspringboot_day9.service.impl;

import com.example.module_javaspringboot_day9.convert.RegistSubjectConvert;
import com.example.module_javaspringboot_day9.dto.RegistSubjectDTO;
import com.example.module_javaspringboot_day9.dto.RegistSubjectDTO;
import com.example.module_javaspringboot_day9.dto.TimeTableDTO;
import com.example.module_javaspringboot_day9.entities.RegistSubjectEntity;
import com.example.module_javaspringboot_day9.entities.RegistSubjectEntity;
import com.example.module_javaspringboot_day9.repository.IRegistSubjectRepositoty;
import com.example.module_javaspringboot_day9.service.IRegistSubjectService;
import com.example.module_javaspringboot_day9.service.ITimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistSubjectServiceIMPL implements IRegistSubjectService {
    @Autowired
    IRegistSubjectRepositoty RegistSubjectRepository;
    @Autowired
    RegistSubjectConvert RegistSubjectConvert;
    @Autowired
    ITimeTableService iTimeTableService;
    @Override
    public List<RegistSubjectDTO> findAll() {
        List<RegistSubjectDTO> dtoList = new ArrayList<>();
        for (RegistSubjectEntity entity: RegistSubjectRepository.findAll()) {
            dtoList.add(RegistSubjectConvert.toDTO(entity));
        }
        return dtoList;
    }

    @Override
    public void saveOrUpdate(RegistSubjectDTO RegistSubjectDTO) {
        if (RegistSubjectDTO.getId() == null){
            RegistSubjectRepository.save(RegistSubjectConvert.toEntity(RegistSubjectDTO));
        }else {
            RegistSubjectEntity oldEntity = RegistSubjectRepository.getById(RegistSubjectDTO.getId());
            RegistSubjectEntity newEntity = RegistSubjectConvert.toEntity(oldEntity,RegistSubjectDTO);
            RegistSubjectRepository.save(newEntity);
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
                if (dtoList.get(i).getName().equals(dtTimeTable.get(j).getName())){
                    check = true;
                }
            }
            if (check == false){
                listSubjectNoneRegist.add(dtoList.get(i));
            }
        }

        return listSubjectNoneRegist;
    }




}
