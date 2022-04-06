package com.example.module_javaspringboot_day7_02.dao;

import com.example.module_javaspringboot_day7_02.convert.EmployeeConvert;
import com.example.module_javaspringboot_day7_02.convert.PositionConvert;
import com.example.module_javaspringboot_day7_02.dto.PositionDTO;
import com.example.module_javaspringboot_day7_02.entities.PositionEntity;
import com.example.module_javaspringboot_day7_02.entities.EmployeeEntity;
import com.example.module_javaspringboot_day7_02.util.ConnectDBUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class PositionDAO {
    PositionConvert convert = new PositionConvert();

    public List<PositionDTO> getAll(){
        List<PositionEntity> entityList = new ArrayList<>();
        List<PositionDTO> dtoList = new ArrayList<>();
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        entityList = session.createQuery("FROM PositionEntity ").list();
        for (int i = 0; i < entityList.size(); i++) {
            dtoList.add(convert.toDTO(entityList.get(i)));
        }
        return dtoList;

    }
    public void saveOrUpdate(PositionDTO position){
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.saveOrUpdate(convert.toEntity(position));

        session.getTransaction().commit();
        session.close();
    }
    public void delete(PositionDTO position){
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(convert.toEntity(position));

        session.getTransaction().commit();
        session.close();
    }
    public PositionDTO findById(int id){
//        PositionEntity position = new PositionEntity();
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        PositionEntity position  = session.find(PositionEntity.class,id);

        return convert.toDTO(position);
    }

    public static void main(String[] args) {
//        PositionDTO Position = new PositionDTO();
//        Position.setId(4);
//        Position.setName("Position 3");
//        Position.setCfc_salary("5");
////        new PositionDAO().getAll();
////        new PositionDAO().saveOrUpdate(Position);
//        new PositionDAO().delete(Position);
//        new PositionDAO().findById(1);

    }
}
