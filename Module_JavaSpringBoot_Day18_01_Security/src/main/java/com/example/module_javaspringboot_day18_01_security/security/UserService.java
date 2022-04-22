package com.example.module_javaspringboot_day18_01_security.security;

import com.example.module_javaspringboot_day18_01_security.entities.UserEntity;
import com.example.module_javaspringboot_day18_01_security.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByUsername(username);

        if (username == null){
            throw new UsernameNotFoundException("User not found !");
        }
        return new CustomerService(userEntity);
    }
}
