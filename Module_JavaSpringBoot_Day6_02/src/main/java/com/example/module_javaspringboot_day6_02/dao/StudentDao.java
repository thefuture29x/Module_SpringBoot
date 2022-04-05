package com.example.module_javaspringboot_day6_02.dao;

import com.example.module_javaspringboot_day6_02.entity.StudentEntity;
import com.example.module_javaspringboot_day6_02.entity.SubjectEntity;
import com.example.module_javaspringboot_day6_02.util.ConnectDBUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public List<StudentEntity> getALlStudent(){
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        List<StudentEntity> entityList = session.createQuery("FROM StudentEntity ").list();
        session.close();
        return entityList;
    }
    public void saveOrUpdate(StudentEntity studentEntity,SubjectEntity subjectEntity){
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        session.beginTransaction();
        studentEntity.setSubject(subjectEntity);
        session.saveOrUpdate(studentEntity);
//        session.getTransaction().commit();
        session.close();
    }
    public void deleteStudent(int id){
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        StudentEntity student = session.find(StudentEntity.class,id);
        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }

    public static void main(String[] args) {
//        new StudentDao().getALlStudent();
//        Session session = ConnectDBUtil.getSessionFactory().openSession();
//        session.beginTransaction();
        StudentEntity studentEntity = new StudentEntity();
        SubjectEntity subjectEntity = new SubjectEntity();

        subjectEntity.setId(1);
        subjectEntity.setName("Toan");
        subjectEntity.setListStudent(new ArrayList<StudentEntity>());

        studentEntity.setId(5);
        studentEntity.setName("Hai Phong");
        studentEntity.setAddress("Ha Noi 2");
//        studentEntity.setSubject(subjectEntity);

        new StudentDao().saveOrUpdate(studentEntity,subjectEntity);

//        session.saveOrUpdate(studentEntity);
//        session.delete(studentEntity);
//        session.getTransaction().commit();
//        session.close();
    }
}
