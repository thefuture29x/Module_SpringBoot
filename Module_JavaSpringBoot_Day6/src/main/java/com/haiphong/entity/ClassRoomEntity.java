package com.haiphong.entity;

public class ClassRoomEntity {
    private Long id;
    private String nameClass;


    public ClassRoomEntity() {
    }

    public ClassRoomEntity(Long id, String nameClass) {
        this.id = id;
        this.nameClass = nameClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
