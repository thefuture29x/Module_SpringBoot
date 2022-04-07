package com.example.module_javaspringboot_day7_02.dao;

import com.example.module_javaspringboot_day7_02.convert.DepartmentConvert;
import com.example.module_javaspringboot_day7_02.convert.EmployeeConvert;
import com.example.module_javaspringboot_day7_02.convert.LogWorkConvert;
import com.example.module_javaspringboot_day7_02.convert.PositionConvert;
import com.example.module_javaspringboot_day7_02.dto.EmployeeDTO;
import com.example.module_javaspringboot_day7_02.dto.LogWorkDTO;
import com.example.module_javaspringboot_day7_02.dto.SalaryDTO;
import com.example.module_javaspringboot_day7_02.entities.EmployeeEntity;
import com.example.module_javaspringboot_day7_02.util.ConnectDBUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    EmployeeConvert convert = new EmployeeConvert();
    PositionConvert convertPS = new PositionConvert();
    DepartmentConvert convertDP = new DepartmentConvert();
    LogWorkConvert convertLW = new LogWorkConvert();
    DepartmentDAO departmentDAO = new DepartmentDAO();
    PositionDAO positionDAO = new PositionDAO();
    LogWorkDAO logWorkDAO = new LogWorkDAO();
    public List<EmployeeDTO> getAll(){
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        List<EmployeeEntity> entityList = session.createQuery("FROM EmployeeEntity ").list();
        List<EmployeeDTO> dtoList = new ArrayList<>();
        for (int i = 0; i < entityList.size(); i++) {
            dtoList.add(convert.toDTO(entityList.get(i)));
        }
        session.close();
        return dtoList;
    }

    public int getSalaryEmployee(int id_empl){
        String sql = " SELECT ep.id ,ps.cfc_salary ,ps.a_days_wages ,lw.work_hours FROM EmployeeEntity ep " +
                " JOIN fetch PositionEntity ps ON ep.empPosition.id = ps.id " +
                " JOIN fetch LogWorkEntity lw ON ep.id = lw.emp_logwork.id " +
                " WHERE ep.id = " + id_empl;
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        Object newObj = new SalaryDTO();
//        List manage = ( session.createQuery(sql).list());
        List manage = ( session.createQuery(sql).list());

        for (int i = 0; i < manage.size(); i++) {
        }
        newObj = manage.get(0);


        session.close();



        return 0;
    }

    public void saveOrUpdate(EmployeeDTO Employee){
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        session.beginTransaction();
        EmployeeEntity entity = new EmployeeEntity();
        entity = convert.toEntity(Employee);
        entity.setEmpPosition(convertPS.toEntity(positionDAO.findById(Employee.getId_post())));
        entity.setEmpDepartment(convertDP.toEntity(departmentDAO.findById(Employee.getId_depart())));

        session.saveOrUpdate(entity);

        session.getTransaction().commit();
        session.close();
    }
    public void delete(EmployeeDTO Employee){
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<LogWorkDTO> dtoList = new ArrayList<>();
        dtoList = logWorkDAO.getLogWorkOfEmpl(Employee.getId());
        for (int i = 0; i < dtoList.size(); i++) {
            if (dtoList.get(i).getEmp_logwork().getId() == Employee.getId()){
                logWorkDAO.delete(dtoList.get(i));
            }
        }

        session.delete(convert.toEntity(Employee));

        session.getTransaction().commit();
        session.close();
    }
    public EmployeeDTO findById(int id){
//        EmployeeEntity Employee = new EmployeeEntity();
        Session session = ConnectDBUtil.getSessionFactory().openSession();
        EmployeeEntity employee = session.find(EmployeeEntity.class,id);

        return convert.toDTO(employee);
    }

    public static void main(String[] args) {
//        EmployeeEntity Employee = new EmployeeEntity();
//        DepartmentEntity department = new DepartmentDAO().findById(1);
//        PositionEntity position = new PositionDAO().findById(1);
//
//        Employee.setId(6);
//        Employee.setName("Employee 3333");
//        Employee.setAddress("Ha LOng");
//        Employee.setPhone("12312313");
//        Employee.setEmpDepartment(department);
//        Employee.setEmpPosition(position);
//        new EmployeeDAO().getAll();
//        new EmployeeDAO().saveOrUpdate(Employee);
//        new EmployeeDAO().delete(Employee);
//        new EmployeeDAO().findById(1);
        new EmployeeDAO().getSalaryEmployee(1);


    }

}
