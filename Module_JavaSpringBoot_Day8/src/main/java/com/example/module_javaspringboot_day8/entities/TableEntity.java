package com.example.module_javaspringboot_day8.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tables")
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    @Column(name = "amount_seat")
    private int amountSeat;
    private String status;
    private int price;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "tableEntity",cascade = CascadeType.ALL)
    private List<TimeBookTableEntity> listTimeBookTable ;

    public TableEntity() {
    }

    public TableEntity(Long id, String name, String description, int amountSeat, String status, int price, UserEntity userEntity, List<TimeBookTableEntity> listTimeBookTable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amountSeat = amountSeat;
        this.status = status;
        this.price = price;
        this.userEntity = userEntity;
        this.listTimeBookTable = listTimeBookTable;
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

    public List<TimeBookTableEntity> getListTimeBookTable() {
        return listTimeBookTable;
    }

    public void setListTimeBookTable(List<TimeBookTableEntity> listTimeBookTable) {
        this.listTimeBookTable = listTimeBookTable;
    }
}
