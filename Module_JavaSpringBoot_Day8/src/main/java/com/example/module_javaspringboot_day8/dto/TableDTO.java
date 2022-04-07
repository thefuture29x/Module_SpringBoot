package com.example.module_javaspringboot_day8.dto;

import com.example.module_javaspringboot_day8.entities.UserEntity;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class TableDTO {
    private Long id;
    private String name;
    private String description;
    private int amountSeat;
    private String status;
    private int price;
    private UserEntity userEntity;

    public TableDTO() {
    }

    public TableDTO(Long id, String name, String description, int amountSeat, String status, int price, UserEntity userEntity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amountSeat = amountSeat;
        this.status = status;
        this.price = price;
        this.userEntity = userEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmountSeat() {
        return amountSeat;
    }

    public void setAmountSeat(int amountSeat) {
        this.amountSeat = amountSeat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
