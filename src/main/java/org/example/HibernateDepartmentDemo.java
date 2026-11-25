package org.example;

import org.example.dao.HibernateDepartmentDao;
import org.example.model.Department;
import org.hibernate.SessionFactory;

public class HibernateDepartmentDemo {
    public static void main(String[] args) {
        System.out.println();
        try (SessionFactory factory = DBConfig.SESSION_FACTORY) {

        }
    }
}
