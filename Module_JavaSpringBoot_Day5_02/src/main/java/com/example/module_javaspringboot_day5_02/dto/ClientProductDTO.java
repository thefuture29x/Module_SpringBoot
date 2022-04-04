package com.example.module_javaspringboot_day5_02.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "client_product")
public class ClientProductDTO {
    @Id
    private int id;
    private int id_user;
    private int id_product;

    public ClientProductDTO() {
    }

    public ClientProductDTO(int id, int id_user, int id_product) {
        this.id = id;
        this.id_user = id_user;
        this.id_product = id_product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }
}
