package com.example.module_javaspringboot_day5_02.repository;

import com.example.module_javaspringboot_day5_02.dto.UserDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<UserDTO,Integer> {

    @Query(value = "select * from user where username =:name and password = :password")
    UserDTO checkInforUser(@Param("name") String username,@Param("password") String password);

    @Query(value = "select * from user where username =:name")
    UserDTO findByName(@Param("name") String username);
}
