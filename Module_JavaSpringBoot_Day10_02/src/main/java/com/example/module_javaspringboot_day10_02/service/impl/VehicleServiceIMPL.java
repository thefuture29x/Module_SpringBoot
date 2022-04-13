package com.example.module_javaspringboot_day10_02.service.impl;

import com.example.module_javaspringboot_day10_02.entities.CategoryVehicleEntity;
import com.example.module_javaspringboot_day10_02.entities.VehicleEntity;
import com.example.module_javaspringboot_day10_02.modal.CategoryVehicleModal;
import com.example.module_javaspringboot_day10_02.modal.VehicleModal;
import com.example.module_javaspringboot_day10_02.repository.ICategoryRepository;
import com.example.module_javaspringboot_day10_02.repository.IVehicleRepository;
import com.example.module_javaspringboot_day10_02.service.ICategoryVehicleService;
import com.example.module_javaspringboot_day10_02.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceIMPL implements IVehicleService {
    @Autowired
    IVehicleRepository iVehicleRepository;
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Autowired
    ICategoryVehicleService iCategoryVehicleService;

    @Override
    public Boolean save(VehicleModal vehicleModal) {
        try{
            if (vehicleModal.getId() == null){
                iVehicleRepository.save(VehicleModal.toEntity(vehicleModal));
            }else {
                VehicleEntity oldEntity = iVehicleRepository.getById(vehicleModal.getId());
                VehicleEntity entity = VehicleModal.toEntity(vehicleModal);
                oldEntity.setId(entity.getId());
                oldEntity.setName(entity.getName());
                oldEntity.setNumerical(entity.getNumerical());
                oldEntity.setNumber(entity.getNumber());
                oldEntity.setColor(entity.getColor());
                oldEntity.setImage(entity.getImage());

                if (vehicleModal.getCategoryVehicleModal() == null){

                    entity.setCategoryVehicleEntity(null);
                }else {
                    CategoryVehicleEntity categoryVehicleEntity = CategoryVehicleModal.toEntity(vehicleModal.getCategoryVehicleModal());
                    oldEntity.setCategoryVehicleEntity(categoryVehicleEntity);
                }

                iVehicleRepository.save(oldEntity);
            }
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<VehicleModal> findAll(Pageable pageable) {
        List<VehicleEntity> vehicleEntityList = iVehicleRepository.findAll(pageable).getContent();
        List<VehicleModal> vehicleModalList = new ArrayList<>();
        for (VehicleEntity entitys : vehicleEntityList) {
            CategoryVehicleModal modal = iCategoryVehicleService.findById(entitys.getCategoryVehicleEntity().getId());
//            CategoryVehicleModal modal = CategoryVehicleEntity.toModal(iCategoryRepository.getById(entitys.getCategoryVehicleEntity().getId()));
//            modal.setDetailCategoryModalList(iCategoryVehicleService.findById(modal.getId()));
            VehicleModal vehicleModal = VehicleEntity.toModal(entitys);
            vehicleModal.setCategoryVehicleModal(modal);
            vehicleModalList.add(vehicleModal);

        }
        return vehicleModalList;
    }

    @Override
    public VehicleModal findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long[] ids) {

    }
}
