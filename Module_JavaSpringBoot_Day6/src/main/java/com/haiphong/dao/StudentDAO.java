package com.haiphong.dao;

import com.haiphong.entity.ClassRoomEntity;
import com.haiphong.entity.StudentEntity;
import com.haiphong.util.ConnectDBUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {
    // khoi tao doi tuong factory session
    // call config connector

    Transaction tx = null;
    public List<StudentEntity> getListStudent(){
        tx = ConnectDBUtil.createConnection().beginTransaction();
        try{
//            List<StudentEntity> student = ConnectDBUtil.createConnection().createQuery("FROM StudentEntity").list();
//            System.out.println(student);
            Session session = ConnectDBUtil.createConnection();
//            List<StudentEntity> student = session.createQuery("from StudentEntity").list();
//            System.out.println(student.size());
//            ClassRoomEntity classRoomEntity = new ClassRoomEntity(0, "class 1");
//            session.save(classRoomEntity);
//            StudentEntity studentE = new StudentEntity(0, "student", classRoomEntity);
//            session.save(studentE);
//            StudentEntity students = ConnectDBUtil.createConnection().find(StudentEntity.class, 1);
//            System.out.println(students.getAddress().getId());
            ConnectDBUtil.createConnection().close();

        }catch (Exception e){
            System.out.println("error =====>>>>" + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
//        new StudentDAO().getListStudent();
    Session session = ConnectDBUtil.createConnection();
    session.beginTransaction();

//    ClassRoomEntity classRoom = new ClassRoomEntity();
//    classRoom.setId(2);
//    classRoom.setNameClass("class 2");
//    session.saveOrUpdate(classRoom);
//

    StudentEntity student = session.find(StudentEntity.class,1);

    student.setName("student 1234");
//    student.setId(1);
//        session.merge(classRoom);
//    student.setAddress(classRoom);



//    System.out.println(session.createQuery("from StudentEntity where id = 1").getSingleResult());
//    session.save(student);
//    session.saveOrUpdate(student);
//    session.saveOrUpdate(classRoom);
//    session.delete(student);
//        StudentEntity studentC = session.find(StudentEntity.class, 1);
//        System.out.println(studentC);

    session.getTransaction().commit();
    session.close();

    }

}
