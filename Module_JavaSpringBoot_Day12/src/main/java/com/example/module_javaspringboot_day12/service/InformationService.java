package com.example.module_javaspringboot_day12.service;

import com.example.module_javaspringboot_day12.dto.InformationDTO;
import com.example.module_javaspringboot_day12.repository.IInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InformationService {
    @Autowired
    IInformationRepository iInformationRepository;

    public List<InformationDTO> getInformation(){
        return iInformationRepository.getAllInformation()
                .stream()
                .map(modal->InformationDTO.builder()
                        .id(modal.getId())
                        .name_class(modal.getName_class())
                        .name_school(modal.getName_school())
                        .name_teacher(modal.getName_teacher())
                        .build()).collect(Collectors.toList());
    }
}
