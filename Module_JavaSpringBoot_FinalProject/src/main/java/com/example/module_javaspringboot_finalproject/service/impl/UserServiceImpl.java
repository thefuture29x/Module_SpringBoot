package com.example.module_javaspringboot_finalproject.service.impl;

import com.example.module_javaspringboot_finalproject.dto.UserDTO;
import com.example.module_javaspringboot_finalproject.entities.RoleEntity;
import com.example.module_javaspringboot_finalproject.entities.UserEntity;
import com.example.module_javaspringboot_finalproject.repository.UserRepository;
import com.example.module_javaspringboot_finalproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> findAllUser() {
        List<UserDTO> dtoList = new ArrayList<>();
        userRepository.findAll().stream().forEach(user ->{
            dtoList.add(UserEntity.toDTO(user));
        });
        return dtoList;
    }

    @Override
    public UserDTO enabledUser(Long id_user) {
        UserEntity userEntity = userRepository.findById(id_user).get();
        if (userEntity.isEnabled()){
            userEntity.setEnabled(false);
        }else{
            userEntity.setEnabled(true);
        }
        userRepository.save(userEntity);
        return UserEntity.toDTO(userEntity);
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity entity = UserDTO.toEntity(userDTO);
        List<RoleEntity> entityList = new ArrayList<>();

        if(userDTO.getPassword() != null){
//            entity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        }
        userRepository.save(entity);
    }

    @Override
    public void downloadImage(String url,String fileLocalPath){
        try(InputStream inputStream = URI.create(url).toURL().openStream()){
            Files.copy(inputStream, Paths.get(fileLocalPath), StandardCopyOption.REPLACE_EXISTING);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUserToken(String email, String token) {
        UserEntity userEntity = userRepository.findByEmail(email);
        userEntity.setResetPassWordToken(token);
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity findUserByToken(String token) {
        return userRepository.findByResetPassWordToken(token);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
