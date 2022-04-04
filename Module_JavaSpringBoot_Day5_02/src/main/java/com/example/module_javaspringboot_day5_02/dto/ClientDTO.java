package com.example.module_javaspringboot_day5_02.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

@Table(value = "client")
public class ClientDTO {
    @Id
    private int id;
    private String name;
    private String address;
    private String phone;
    private int total;

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", total=" + total +
                '}';
    }

    public ClientDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ClientDTO(int id, String name, String address, String phone, int total) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.total = total;
    }
}
