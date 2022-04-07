package com.example.module_javaspringboot_day7_02.dao;

import com.example.module_javaspringboot_day7_02.convert.EmployeeConvert;
import com.example.module_javaspringboot_day7_02.convert.LogWorkConvert;
import com.example.module_javaspringboot_day7_02.dto.LogWorkDTO;
import com.example.module_javaspringboot_day7_02.entities.LogWorkEntity;
import com.example.module_javaspringboot_day7_02.util.ConnectDBUtil;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogWorkDAO {
    LogWorkConvert convert = new LogWorkConvert();


    public List<LogWorkDTO> getAll(){
        List<LogWorkEntity> entityList = new ArrayList<>();
        List<LogWorkDTO> dtoList = new ArrayList<>();
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        entityList = session.createQuery("FROM LogWorkEntity ").list();
        for (int i = 0; i < entityList.size(); i++) {
            dtoList.add(convert.toDTO(entityList.get(i)));
        }
        return dtoList;

    }
    public void saveOrUpdate(LogWorkDTO LogWork){
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.saveOrUpdate(convert.toEntity(LogWork));

        session.getTransaction().commit();
        session.close();
    }
    public void delete(LogWorkDTO LogWork){
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(convert.toEntity(LogWork));

        session.getTransaction().commit();
        session.close();
    }
    public LogWorkDTO findById(int id){
//        LogWorkEntity LogWork = new LogWorkEntity();
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        LogWorkEntity LogWork  = session.find(LogWorkEntity.class,id);

        return convert.toDTO(LogWork);
    }
    public int timekeeping(int id_empl){
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        List<LogWorkEntity> entityList = session.createQuery("FROM LogWorkEntity where emp_logwork = " + id_empl).list();
        int timekeeping = 0;
        for (int i = 0; i < entityList.size(); i++) {
            timekeeping += entityList.get(i).getWork_hours();
        }
        return timekeeping/8;
    }

    public List<LogWorkDTO> getLogWorkOfEmpl(int id_empl){
        List<LogWorkEntity> entityList = new ArrayList<>();
        List<LogWorkDTO> dtoList = new ArrayList<>();
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        entityList = session.createQuery("FROM LogWorkEntity where emp_logwork = " + id_empl).list();
        for (int i = 0; i < entityList.size(); i++) {
            dtoList.add(convert.toDTO(entityList.get(i)));
        }
        return dtoList;
    }

    public static void main(String[] args) {
        LogWorkDTO LogWork = new LogWorkDTO();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        EmployeeConvert convert = new EmployeeConvert();
        String oldstring = "04/04/2022";
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(oldstring);
            LogWork.setDate_start(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        LogWork.setId(0);
        LogWork.setEmp_logwork(convert.toEntity(employeeDAO.findById(1)));
        LogWork.setWork_hours(8);
        LogWork.setDescription("08:30 -- 17:00");

//        new LogWorkDAO().saveOrUpdate(LogWork);
//        new LogWorkDAO().getAll();
        new LogWorkDAO().getLogWorkOfEmpl(1);

//        LogWork.setDate_start();
//        LogWork.setDate_end(0);

//        LogWork.setName("LogWork 3");
//        LogWork.setCfc_salary("5");
////        new LogWorkDAO().getAll();
////        new LogWorkDAO().saveOrUpdate(LogWork);
//        new LogWorkDAO().delete(LogWork);
//        new LogWorkDAO().findById(1);

    }
}
