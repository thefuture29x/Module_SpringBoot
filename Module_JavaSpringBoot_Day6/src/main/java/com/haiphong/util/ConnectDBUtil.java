package com.haiphong.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ConnectDBUtil {
    private static SessionFactory factory;

    public static Session createConnection(){
        try{
            factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
            Session session = factory.openSession();
            System.out.println("Connection !!!");
            return session;
        }catch (Exception e){
            System.out.println("Error configuration " + e.getMessage());
        }
        return null;
    }
}
