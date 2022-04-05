package com.haiphong.entity;

import java.util.List;

public class ClassRoomEntity {
    private Integer id;
    private String nameClass;
//    private List<StudentEntity> stus;
    public ClassRoomEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }



    @Override
    public String toString() {
        return "ClassRoomEntity{" +
                "id=" + id +
                ", nameClass='" + nameClass + '\'' +
                ", stus="  +
                '}';
    }
}
