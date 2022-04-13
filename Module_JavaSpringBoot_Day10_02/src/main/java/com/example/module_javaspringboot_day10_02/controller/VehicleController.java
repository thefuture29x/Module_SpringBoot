package com.example.module_javaspringboot_day10_02.controller;

import com.example.module_javaspringboot_day10_02.dto.CategoryVehicleDTO;
import com.example.module_javaspringboot_day10_02.dto.DetailCategoryDTO;
import com.example.module_javaspringboot_day10_02.dto.VehicleDTO;
import com.example.module_javaspringboot_day10_02.entities.CategoryVehicleEntity;
import com.example.module_javaspringboot_day10_02.entities.DetailCategoryEntity;
import com.example.module_javaspringboot_day10_02.entities.VehicleEntity;
import com.example.module_javaspringboot_day10_02.modal.CategoryVehicleModal;
import com.example.module_javaspringboot_day10_02.modal.DetailCategoryModal;
import com.example.module_javaspringboot_day10_02.modal.VehicleModal;
import com.example.module_javaspringboot_day10_02.service.ICategoryVehicleService;
import com.example.module_javaspringboot_day10_02.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {
    @Autowired
    IVehicleService iVehicleService;
    @Autowired
    ICategoryVehicleService iCategoryVehicleService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllVehicle(Pageable pageable){
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        List<VehicleModal> vehicleModalList = iVehicleService.findAll(pageable);
        for (VehicleModal modals : vehicleModalList) {
            CategoryVehicleModal modal = iCategoryVehicleService.findById(modals.getCategoryVehicleModal().getId());
            CategoryVehicleDTO dto = CategoryVehicleModal.toDTO(modal);
            List<DetailCategoryDTO> detailCategoryDTOS = new ArrayList<>();
            for (DetailCategoryModal details : modal.getDetailCategoryModalList()) {
                detailCategoryDTOS.add(DetailCategoryModal.toDTO(details));
            }
            dto.setDetailCategoryDTOList(detailCategoryDTOS);

            VehicleDTO vehicleDTO = VehicleModal.toDTO(modals);
            vehicleDTO.setCategoryVehicleDTO(dto);

            vehicleDTOList.add(vehicleDTO);

        }
        return ResponseEntity.ok().body(vehicleDTOList);
    }

    @PostMapping("/save-vehicle")
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO ,@RequestParam(value = "image-vehicle") MultipartFile file){
        vehicleDTO.setImage(uploadFile(file));
        iVehicleService.save(VehicleDTO.toModal(vehicleDTO));
        return vehicleDTO;
    }
    @GetMapping("/get-category")
    public CategoryVehicleDTO getCategoryModal(@RequestBody CategoryVehicleDTO categoryVehicleDTO){
        CategoryVehicleModal modal = iCategoryVehicleService.findById(categoryVehicleDTO.getId());
        CategoryVehicleDTO dto = CategoryVehicleModal.toDTO(modal);
        List<DetailCategoryDTO> detailCategoryDTOS = new ArrayList<>();
        for (DetailCategoryModal details : modal.getDetailCategoryModalList()) {
            detailCategoryDTOS.add(DetailCategoryModal.toDTO(details));
        }
        dto.setDetailCategoryDTOList(detailCategoryDTOS);
        return dto;
    }

    public String uploadFile(MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();
        String replaceFileName = fileName.replaceAll("\\s+", "");
        String uploadDir = "./src/main/resources/static/image-product/";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(replaceFileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return replaceFileName;
    }

}
