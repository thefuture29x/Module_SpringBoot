package com.example.module_javaspringboot_day5_02.repository;


import com.example.module_javaspringboot_day5_02.dto.ClientProductDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientProductRepository extends CrudRepository<ClientProductDTO, Integer> {
    @Query(value = " SELECT * FROM client_product cp " +
            " JOIN client cl ON cl.id = cp.id_client " +
            " JOIN product pr ON pr.id = cp.id_product " +
            " WHERE cp.id = :id")
    ClientProductDTO findByName(@Param("id") int id);

}
