package com.example.module_javaspringboot_day6_02.controller;


import com.example.module_javaspringboot_day6_02.dao.StudentDao;
import com.example.module_javaspringboot_day6_02.entity.StudentEntity;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Student", value = "/student")
public class StudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id_student") != null){
            req.getRequestDispatcher("edit.jsp").forward(req,resp);
        }else {
            StudentDao studentDao = new StudentDao();
            List<StudentEntity> entityList  = studentDao.getALlStudent();
            req.setAttribute("listStudent",entityList);
            req.getRequestDispatcher("list_student.jsp").forward(req,resp);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_student = Integer.parseInt(req.getParameter("id_student"));
        StudentDao studentDao = new StudentDao();
//        studentDao.saveOrUpdate();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
