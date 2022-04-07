package com.example.module_javaspringboot_day8.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
    private List<TableEntity> listTable ;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, List<TableEntity> listTable) {
        this.id = id;
        this.name = name;
        this.listTable = listTable;
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

    public List<TableEntity> getListTable() {
        return listTable;
    }

    public void setListTable(List<TableEntity> listTable) {
        this.listTable = listTable;
    }
}
