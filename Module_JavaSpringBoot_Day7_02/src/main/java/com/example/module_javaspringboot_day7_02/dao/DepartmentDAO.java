package com.example.module_javaspringboot_day7_02.dao;

import com.example.module_javaspringboot_day7_02.convert.DepartmentConvert;
import com.example.module_javaspringboot_day7_02.dto.DepartmentDTO;
import com.example.module_javaspringboot_day7_02.entities.DepartmentEntity;
import com.example.module_javaspringboot_day7_02.entities.EmployeeEntity;
import com.example.module_javaspringboot_day7_02.util.ConnectDBUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    DepartmentConvert convert = new DepartmentConvert();
    public List<DepartmentDTO> getAll(){
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        List<DepartmentEntity> entityList = session.createQuery("FROM DepartmentEntity").list();
        List<DepartmentDTO> dtoList = new ArrayList<>();
        for (int i = 0; i < entityList.size(); i++) {
            dtoList.add(convert.toDTO(entityList.get(i)));
        }
        return dtoList;

    }
    public void saveOrUpdate(DepartmentDTO department){
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(convert.toEntity(department));

        session.getTransaction().commit();
        session.close();
    }
    public void delete(DepartmentDTO department){
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(convert.toEntity(department));

        session.getTransaction().commit();
        session.close();
    }
    public DepartmentDTO findById(int id){
        DepartmentEntity department = new DepartmentEntity();
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        department = session.find(DepartmentEntity.class,id);

        return convert.toDTO(department);
    }

    public static void main(String[] args) {
//        DepartmentEntity department = new DepartmentEntity();
//        department.setId(4);
//        department.setName("Department 3");
//        department.setListEmp(new ArrayList<EmployeeEntity>());
////        new DepartmentDAO().getAll();
//        new DepartmentDAO().saveOrUpdate(department);
//        new DepartmentDAO().delete(department);
//        new DepartmentDAO().findById(1);

    }
}
