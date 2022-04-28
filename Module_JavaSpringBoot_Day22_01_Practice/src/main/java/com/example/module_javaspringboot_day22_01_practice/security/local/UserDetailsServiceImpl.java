package com.example.module_javaspringboot_day22_01_practice.security.local;

import com.example.module_javaspringboot_day22_01_practice.entities.UserEntity;
import com.example.module_javaspringboot_day22_01_practice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = iUserRepository.findByEmail(username);
        if (username == null){
            throw new UsernameNotFoundException("User not found !");
        }
        UserDetailsImpl userDetails = new UserDetailsImpl(userEntity);
        return userDetails;
    }
}
