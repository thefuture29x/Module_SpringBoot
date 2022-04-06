package com.example.module_javaspringboot_day7_02.util;

import com.example.module_javaspringboot_day7_02.entities.DepartmentEntity;
import com.example.module_javaspringboot_day7_02.entities.EmployeeEntity;
import com.example.module_javaspringboot_day7_02.entities.LogWorkEntity;
import com.example.module_javaspringboot_day7_02.entities.PositionEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class ConnectDBUtil {
    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/lab4?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(DepartmentEntity.class);
                configuration.addAnnotatedClass(PositionEntity.class);
                configuration.addAnnotatedClass(EmployeeEntity.class);
                configuration.addAnnotatedClass(LogWorkEntity.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                System.out.println("ket noi thanh cong");
                return sessionFactory;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return sessionFactory;
    }

    public static void main(String[] args) {
        new ConnectDBUtil().getSessionFactory();
    }
}
