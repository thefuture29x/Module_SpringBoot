package com.haiphong;

import com.haiphong.util.ConnectDBUtil;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ModuleJavaSpringBootDay6Application {

//    StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();


    public static void main(String[] args) {
        ConnectDBUtil connectDBUtil = new ConnectDBUtil();
        connectDBUtil.createConnection();
    }

}
